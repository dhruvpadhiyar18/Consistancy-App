package com.consistancy.app

object QuizProvider {

    fun getDailyQuiz(day: Int): List<QuizQuestion> {
        return when (day) {
            1 -> listOf(
                QuizQuestion("What is Python predominantly used for?", listOf("Hardware only", "AI, Web, Automation", "Only simple math", "None"), 1),
                QuizQuestion("In problem solving, which step comes first?", listOf("Writing code", "Understanding the problem", "Deployment", "None"), 1)
            )
            2 -> listOf(
                QuizQuestion("Which data type is used for numbers with decimals?", listOf("int", "float", "boolean", "string"), 1),
                QuizQuestion("Python code runs...", listOf("All at once", "Line by line", "Backwards", "None"), 1)
            )
            3 -> listOf(
                QuizQuestion("What keyword starts a conditional check?", listOf("if", "loop", "run", "do"), 0),
                QuizQuestion("When does the 'else' block run?", listOf("Always", "When 'if' is true", "When 'if' is false", "Never"), 2)
            )
            4 -> listOf(
                QuizQuestion("Which loop is used when you know exactly how many times to repeat?", listOf("while", "if", "for", "else"), 2),
                QuizQuestion("What does 'while' loop check before executing?", listOf("A condition", "A number", "A string", "None"), 0)
            )
            5 -> listOf(
                QuizQuestion("How do you define a function in Python?", listOf("func", "define", "def", "function"), 2),
                QuizQuestion("Functions help in making code...", listOf("Harder", "Reusable", "Slower", "None"), 1)
            )
            6 -> listOf(
                QuizQuestion("Python lists are...", listOf("Immutable", "Ordered & Changeable", "Fixed size", "None"), 1),
                QuizQuestion("Which method adds an element to a list?", listOf("add()", "push()", "append()", "extend()"), 2)
            )
            7 -> listOf(
                QuizQuestion("Which collection is immutable (cannot be changed)?", listOf("List", "Set", "Tuple", "Dict"), 2),
                QuizQuestion("Sets are used to store...", listOf("Duplicates", "Unique items", "Pairs", "None"), 1)
            )
            // Default quiz for other days
            else -> listOf(
                QuizQuestion("Consistency is the key to...", listOf("Failure", "Mastery", "Speed", "Boredom"), 1),
                QuizQuestion("How many tasks are there daily?", listOf("1", "2", "5", "10"), 1)
            )
        }
    }

    fun getProgressReviewQuiz(reviewIndex: Int): List<QuizQuestion> {
        // reviewIndex 1 covers first 7 days, etc.
        return when (reviewIndex) {
            1 -> listOf(
                QuizQuestion("Python's main advantage in AI is...", listOf("Complexity", "Syntax speed", "Readability & Libraries", "None"), 2),
                QuizQuestion("Logic building comes...", listOf("After coding", "Before coding", "Never", "Randomly"), 1),
                QuizQuestion("A float stores...", listOf("Text", "Decimals", "Integers", "True/False"), 1),
                QuizQuestion("Conditionals enable...", listOf("Repetition", "Decision making", "Deleting data", "None"), 1),
                QuizQuestion("Loops prevent...", listOf("Clean code", "Redundant code", "Speed", "Logic"), 1),
                QuizQuestion("Functions are called using...", listOf("[]", "()", "{}", "<>"), 1),
                QuizQuestion("Lists use which brackets?", listOf("[]", "()", "{}", "<>"), 0),
                QuizQuestion("Sets handle unique items...", listOf("Slowly", "Efficiently", "Manually", "None"), 1)
            )
            else -> listOf(
                QuizQuestion("Data Structures help in...", listOf("UI only", "Efficient data handling", "Typing faster", "None"), 1),
                QuizQuestion("Big-O notation is for...", listOf("Measuring memory", "Complexity analysis", "Naming variables", "None"), 1)
            )
        }
    }
}
