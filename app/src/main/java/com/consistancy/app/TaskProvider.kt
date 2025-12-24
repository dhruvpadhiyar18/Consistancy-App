package com.consistancy.app

object TaskProvider {

    fun getTasksForDay(day: Int): List<Task> {

        return when {
            day in 1..30 -> listOf(
                Task("Python Basics", "45 min", "https://docs.python.org/3/tutorial/"),
                Task("DSA – Arrays", "30 min", "https://www.geeksforgeeks.org/array-data-structure/"),
                Task("Project – Android UI", "45 min", "https://developer.android.com")
            )

            day in 31..60 -> listOf(
                Task("OOP in Python", "45 min", "https://realpython.com"),
                Task("DSA – Strings", "30 min", "https://leetcode.com"),
                Task("Project – App Logic", "45 min", "https://developer.android.com")
            )

            else -> listOf(
                Task("Revision", "60 min", "https://google.com"),
                Task("Mini Project Work", "60 min", "https://github.com")
            )
        }
    }
}
