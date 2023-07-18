package com.msayeh.codelab_stateincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.msayeh.codelab_stateincompose.components.WellnessScreen
import com.msayeh.codelab_stateincompose.ui.theme.CodelabStateInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelabStateInComposeTheme {
                WellnessApp()
            }
        }
    }
}

@Composable
fun WellnessApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        WellnessScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CodelabStateInComposeTheme {
        WellnessApp()
    }
}