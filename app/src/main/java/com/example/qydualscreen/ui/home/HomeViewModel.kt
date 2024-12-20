package com.example.qydualscreen.ui.home

import android.app.Application
import android.content.Context
import android.hardware.display.DisplayManager
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Display
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class HomeState(
    val showingDisplay: Display? = null,
    val displayList: List<Display> = emptyList(),
)

suspend inline fun <T> MutableStateFlow<T>.emitState(newState: T.() -> T) {
    emit(newState(value))
}

inline fun <T> MutableStateFlow<T>.updateState(newState: T.() -> T) {
    value = newState(value)
}


class HomeViewModel(
    application: Application,
) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())

    val displayManager = application.getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
    val state: StateFlow<HomeState> = _state
    private var homePresentation: HomePresentation? = null

    private val displayListener = object : DisplayManager.DisplayListener {
        override fun onDisplayAdded(displayId: Int) {
            updateDisplayList()
        }

        override fun onDisplayRemoved(displayId: Int) {
            updateDisplayList()
        }

        override fun onDisplayChanged(displayId: Int) {
            updateDisplayList()
        }
    }

    init {
        displayManager.registerDisplayListener(displayListener, Handler(Looper.getMainLooper()))
        updateDisplayList()
    }

    override fun onCleared() {
        super.onCleared()
        displayManager.unregisterDisplayListener(displayListener)
    }

    private fun updateDisplayList() {
        viewModelScope.launch {
            _state.emitState {
                copy(displayList = displayManager.displays.toList().apply {
                    Log.d("HomeViewModel", "updateDisplayList: $this")
                })
            }
        }
    }

    fun toggleDisplay(display: Display) {
        if (_state.value.showingDisplay == display) {
            hideHomePresentation()
        } else {
            showHomePresentation(display)
        }
    }

    private fun hideHomePresentation() {
        updateShowingDisplay(null)
        homePresentation?.dismiss()
    }

    private fun showHomePresentation(display: Display) {
        updateShowingDisplay(display)
        homePresentation = HomePresentation(getApplication(), display) {
            updateShowingDisplay(null)
        }
        homePresentation?.show()
    }

    private fun updateShowingDisplay(display: Display?) {
        _state.updateState { copy(showingDisplay = display) }
    }
}

