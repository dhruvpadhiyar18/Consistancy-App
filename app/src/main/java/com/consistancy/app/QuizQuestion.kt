package com.consistancy.app

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctOptionIndex: Int
)
