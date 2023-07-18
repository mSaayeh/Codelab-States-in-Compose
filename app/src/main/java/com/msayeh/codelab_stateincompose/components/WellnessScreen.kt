package com.msayeh.codelab_stateincompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.msayeh.codelab_stateincompose.WellnessViewModel
import com.msayeh.codelab_stateincompose.ui.theme.CodelabStateInComposeTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    viewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        val tasksList = remember {
            viewModel.tasks
        }
        WellnessTasksList(
            onClose = { viewModel.removeTask(it) },
            list = tasksList,
            onCheckedChange = { task, checked -> viewModel.changeTaskCheckedState(task, checked) })
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    CodelabStateInComposeTheme {
        WellnessScreen()
    }
}