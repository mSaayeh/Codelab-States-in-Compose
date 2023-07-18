package com.msayeh.codelab_stateincompose

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.msayeh.codelab_stateincompose.data.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun removeTask(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun changeTaskCheckedState(task: WellnessTask, checked: Boolean) {
        tasks.find {
            it.id == task.id
        }?.checked?.value = checked
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }