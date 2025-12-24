package com.consistancy.app

data class Task(
    val title: String,
    val duration: String,
    val resource: String,
    var completed: Boolean = false
)
