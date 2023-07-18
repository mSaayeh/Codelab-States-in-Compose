package com.msayeh.codelab_stateincompose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msayeh.codelab_stateincompose.ui.theme.CodelabStateInComposeTheme

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(count = count, onAddPressed = { count++ }, modifier = modifier)
}

@Composable
fun StatelessCounter(count: Int, onAddPressed: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//            var showTask by rememberSaveable {
//                mutableStateOf(true)
//            }
//            if (showTask) {
//                WellnessTaskItem(
//                    taskName = "Have you taken your 15 minute walk today?",
//                    onClose = { showTask = false },
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//            }
        AnimatedVisibility(
            visible = count > 0,
            enter = fadeIn(tween(250)) + slideInVertically(tween(250))
        ) {
            Text(
                text = "You've had $count glasses of water."
            )
        }
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
        Button(onClick = onAddPressed, enabled = count < 10) {
            Text(text = "Add a glass")
        }
//            Button(onClick = { count = 0 }, enabled = count > 0) {
//                Text(text = "Clear water count")
//            }
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    CodelabStateInComposeTheme {
        StatelessCounter(10, {}, Modifier.padding(vertical = 16.dp))
    }
}