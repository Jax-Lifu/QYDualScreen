package com.example.qydualscreen.ui.secondary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.qydualscreen.R


@Composable
fun PresentationScreen(
    modifier: Modifier = Modifier,
    onCloseClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Button(onClick = onCloseClick) {
            Text(text = "Close Secondary Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = R.mipmap.ic_qytech,
            contentDescription = null,
            modifier.height(160.dp)
        )
    }
}