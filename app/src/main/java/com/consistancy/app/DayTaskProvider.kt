package com.consistancy.app

object DayTaskProvider {

    fun getTasksForDay(day: Int): List<DayTask> {
        return when (day) {

            1 -> listOf(
                DayTask(
                    "Python: Introduction",
                    "Learn print() and input()",
                    "https://www.youtube.com/watch?v=rfscVS0vtbw"
                ),
                DayTask(
                    "DSA: Arrays",
                    "Understand arrays and use-cases",
                    "https://www.geeksforgeeks.org/array-data-structure/"
                )
            )

            else -> listOf(
                DayTask(
                    "Python: Revision",
                    "Revise previous topics",
                    "https://docs.python.org/3/tutorial/"
                ),
                DayTask(
                    "DSA: Revision",
                    "Revise array concepts",
                    "https://www.geeksforgeeks.org/data-structures/"
                )
            )
        }
    }
}
