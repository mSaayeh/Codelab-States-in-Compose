package com.msayeh.codelab_stateincompose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msayeh.codelab_stateincompose.R
import com.msayeh.codelab_stateincompose.ui.theme.CodelabStateInComposeTheme

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    WellnessTaskItemStateless(
        taskName = taskName,
        onClose = onClose,
        checked = checked,
        onCheckChange = onCheckedChange,
        modifier = modifier
    )
}

@Composable
fun WellnessTaskItemStateless(
    taskName: String,
    onClose: () -> Unit,
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                text = taskName, modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            )
            Checkbox(checked = checked, onCheckedChange = onCheckChange)
            IconButton(onClick = onClose) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.cancel)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    CodelabStateInComposeTheme {
        Surface(modifier = Modifier.padding(top = 16.dp)) {
            WellnessTaskItem("Testing Task", {}, false, {})
        }
    }
}