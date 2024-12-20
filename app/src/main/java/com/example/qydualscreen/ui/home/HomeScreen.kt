package com.example.qydualscreen.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.qydualscreen.ui.icons.Display
import com.example.qydualscreen.ui.icons.QYIcons

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: HomeViewModel = viewModel()
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (state.displayList.isEmpty()) {
            Text("没有可用的副屏", style = MaterialTheme.typography.titleLarge)
        } else {
            LazyColumn(
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(state.displayList) {
                    val color = if (it.displayId == 0) Color.Gray else Color.Black
                    ListItem(
                        leadingContent = {
                            Icon(
                                QYIcons.Default.Display, contentDescription = null, tint = color
                            )
                        },
                        headlineContent = {
                            Text(
                                "displayId:${it.displayId} --- name:${it.name}",
                                maxLines = 1,
                                style = MaterialTheme.typography.bodyMedium,
                                color = color
                            )
                        },
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .clickable(enabled = it.displayId != 0) {
                                viewModel.toggleDisplay(it)
                            }
                    )
                }
            }
        }
    }

}