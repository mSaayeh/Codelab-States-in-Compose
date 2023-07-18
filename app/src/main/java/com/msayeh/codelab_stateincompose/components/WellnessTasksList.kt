package com.msayeh.codelab_stateincompose.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.msayeh.codelab_stateincompose.data.WellnessTask
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WellnessTasksList(
    onClose: (WellnessTask) -> Unit,
    list: List<WellnessTask>,
    onCheckedChange: (WellnessTask, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomEnd
    ) {
        LazyColumn(state = scrollState) {
            items(list, key = { it.id }) { task ->
                WellnessTaskItem(
                    taskName = task.label,
                    onClose = { onClose(task) },
                    task.checked.value,
                    { onCheckedChange(task, it) },
                    modifier = Modifier.animateItemPlacement(tween(durationMillis = 250))
                )
            }
        }

        val isButtonVisible by remember {
            derivedStateOf { scrollState.canScrollForward && scrollState.firstVisibleItemIndex > 0 }
        }

        AnimatedVisibility(
            visible = isButtonVisible,
            enter = slideInVertically { it },
            exit = slideOutVertically { it }) {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier.padding(16.dp),
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Scroll to Top",
                    modifier = Modifier
                        .rotate(90f)
                        .padding(4.dp),
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
        }
    }
}