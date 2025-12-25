package com.consistancy.app

object DayTaskProvider {

    fun getTasksForDay(day: Int): List<DayTask> {
        return when (day) {

            1 -> listOf(
                DayTask(
                    title = "Intro to Programming & Python",
                    whatToDo = "Understand what programming is and why Python is used. Watch first 30 minutes.",
                    whyThisMatters = "Programming builds logical thinking. Python is core for AI, automation, and apps.",
                    resourceUrl = "https://www.youtube.com/watch?v=rfscVS0vtbw"
                ),
                DayTask(
                    title = "Problem Solving Basics",
                    whatToDo = "Learn how to break problems into steps before coding.",
                    whyThisMatters = "Thinking clearly matters more than syntax.",
                    resourceUrl = "https://www.geeksforgeeks.org/how-to-solve-algorithms/"
                )
            )

            2 -> listOf(
                DayTask(
                    title = "Variables & Data Types",
                    whatToDo = "Learn int, float, string, boolean with examples.",
                    whyThisMatters = "All programs work on data. This is the foundation.",
                    resourceUrl = "https://www.w3schools.com/python/python_variables.asp"
                ),
                DayTask(
                    title = "Execution Flow",
                    whatToDo = "Understand how code runs line by line.",
                    whyThisMatters = "Removes 80% beginner confusion.",
                    resourceUrl = "https://www.geeksforgeeks.org/programming-fundamentals/"
                )
            )

            3 -> listOf(
                DayTask(
                    title = "Operators in Python",
                    whatToDo = "Learn arithmetic, comparison, and logical operators.",
                    whyThisMatters = "Operators are used in every real program.",
                    resourceUrl = "https://www.w3schools.com/python/python_operators.asp"
                ),
                DayTask(
                    title = "Practice Simple Expressions",
                    whatToDo = "Try 10 small examples using operators.",
                    whyThisMatters = "Practice converts theory into skill.",
                    resourceUrl = "https://www.programiz.com/python-programming/operators"
                )
            )

            4 -> listOf(
                DayTask(
                    title = "Conditional Statements",
                    whatToDo = "Learn if, else, elif with examples.",
                    whyThisMatters = "Conditions make programs intelligent.",
                    resourceUrl = "https://www.w3schools.com/python/python_conditions.asp"
                ),
                DayTask(
                    title = "Decision Making Practice",
                    whatToDo = "Write 5 decision-based programs.",
                    whyThisMatters = "Logic building is critical for interviews.",
                    resourceUrl = "https://www.geeksforgeeks.org/python-if-else/"
                )
            )

            5 -> listOf(
                DayTask(
                    title = "Loops – for loop",
                    whatToDo = "Understand how for loops work.",
                    whyThisMatters = "Loops save time and avoid repetition.",
                    resourceUrl = "https://www.w3schools.com/python/python_for_loops.asp"
                ),
                DayTask(
                    title = "Loop Practice",
                    whatToDo = "Print patterns and number sequences.",
                    whyThisMatters = "Loops appear in almost every coding problem.",
                    resourceUrl = "https://www.programiz.com/python-programming/for-loop"
                )
            )

            6 -> listOf(
                DayTask(
                    title = "while Loop",
                    whatToDo = "Learn while loop and loop conditions.",
                    whyThisMatters = "Some problems need condition-based loops.",
                    resourceUrl = "https://www.w3schools.com/python/python_while_loops.asp"
                ),
                DayTask(
                    title = "Loop Control",
                    whatToDo = "Learn break and continue.",
                    whyThisMatters = "Gives control over program flow.",
                    resourceUrl = "https://www.geeksforgeeks.org/python-break-continue/"
                )
            )

            7 -> listOf(
                DayTask(
                    title = "Lists in Python",
                    whatToDo = "Learn list creation, indexing, slicing.",
                    whyThisMatters = "Lists store real-world data collections.",
                    resourceUrl = "https://www.w3schools.com/python/python_lists.asp"
                ),
                DayTask(
                    title = "List Practice",
                    whatToDo = "Solve 10 list-based questions.",
                    whyThisMatters = "Lists are used in DSA and projects.",
                    resourceUrl = "https://www.programiz.com/python-programming/list"
                )
            )

            8 -> listOf(
                DayTask(
                    title = "Tuples & Sets",
                    whatToDo = "Understand difference between tuple and set.",
                    whyThisMatters = "Choosing correct data structure matters.",
                    resourceUrl = "https://www.w3schools.com/python/python_tuples.asp"
                ),
                DayTask(
                    title = "Set Operations",
                    whatToDo = "Learn union, intersection.",
                    whyThisMatters = "Useful in real data processing.",
                    resourceUrl = "https://www.geeksforgeeks.org/python-sets/"
                )
            )

            9 -> listOf(
                DayTask(
                    title = "Dictionaries",
                    whatToDo = "Learn key-value pairs.",
                    whyThisMatters = "Dictionaries model real-world data.",
                    resourceUrl = "https://www.w3schools.com/python/python_dictionaries.asp"
                ),
                DayTask(
                    title = "Dictionary Practice",
                    whatToDo = "Build small dictionary-based programs.",
                    whyThisMatters = "Used heavily in APIs & backend.",
                    resourceUrl = "https://www.programiz.com/python-programming/dictionary"
                )
            )

            10 -> listOf(
                DayTask(
                    title = "Functions in Python",
                    whatToDo = "Learn how to define and call functions.",
                    whyThisMatters = "Functions make code reusable.",
                    resourceUrl = "https://www.w3schools.com/python/python_functions.asp"
                ),
                DayTask(
                    title = "Function Practice",
                    whatToDo = "Write functions for simple problems.",
                    whyThisMatters = "Functions are interview essentials.",
                    resourceUrl = "https://www.geeksforgeeks.org/python-functions/"
                )
            )

            in 11..15 -> listOf(
                DayTask(
                    title = "Time & Space Complexity",
                    whatToDo = "Understand Big-O basics.",
                    whyThisMatters = "Efficiency matters in interviews.",
                    resourceUrl = "https://www.geeksforgeeks.org/analysis-of-algorithms-set-1-asymptotic-analysis/"
                ),
                DayTask(
                    title = "Simple Complexity Examples",
                    whatToDo = "Analyze 5 code snippets.",
                    whyThisMatters = "Sharpens problem-solving thinking.",
                    resourceUrl = "https://www.programiz.com/dsa/asymptotic-notations"
                )
            )

            in 16..20 -> listOf(
                DayTask(
                    title = "Arrays Basics",
                    whatToDo = "Understand arrays and indexing.",
                    whyThisMatters = "Arrays are base of all DSA.",
                    resourceUrl = "https://www.geeksforgeeks.org/array-data-structure/"
                ),
                DayTask(
                    title = "Array Practice",
                    whatToDo = "Solve 5 array problems.",
                    whyThisMatters = "Improves logic speed.",
                    resourceUrl = "https://leetcode.com/tag/array/"
                )
            )

            in 21..25 -> listOf(
                DayTask(
                    title = "Searching Algorithms",
                    whatToDo = "Learn linear & binary search.",
                    whyThisMatters = "Searching is a core algorithm.",
                    resourceUrl = "https://www.geeksforgeeks.org/searching-algorithms/"
                ),
                DayTask(
                    title = "Binary Search Practice",
                    whatToDo = "Solve 3 binary search problems.",
                    whyThisMatters = "Very common in interviews.",
                    resourceUrl = "https://leetcode.com/tag/binary-search/"
                )
            )

            in 26..30 -> listOf(
                DayTask(
                    title = "Sorting Algorithms",
                    whatToDo = "Learn bubble, selection, insertion sort.",
                    whyThisMatters = "Sorting is used everywhere.",
                    resourceUrl = "https://www.geeksforgeeks.org/sorting-algorithms/"
                ),
                DayTask(
                    title = "Sorting Practice",
                    whatToDo = "Manually dry-run sorting algorithms.",
                    whyThisMatters = "Builds deep understanding.",
                    resourceUrl = "https://visualgo.net/en/sorting"
                )
            )

            in 31..35 -> listOf(
                DayTask(
                    title = "Intro to NumPy",
                    whatToDo = "Learn NumPy arrays and basic operations.",
                    whyThisMatters = "NumPy is the foundation of ML computations.",
                    resourceUrl = "https://www.w3schools.com/python/numpy_intro.asp"
                ),
                DayTask(
                    title = "NumPy Practice",
                    whatToDo = "Create arrays and perform operations.",
                    whyThisMatters = "ML models work on numerical data.",
                    resourceUrl = "https://www.programiz.com/python-programming/numpy"
                )
            )

            in 36..40 -> listOf(
                DayTask(
                    title = "Intro to Pandas",
                    whatToDo = "Learn DataFrames and reading CSV files.",
                    whyThisMatters = "Most ML work starts with data cleaning.",
                    resourceUrl = "https://www.w3schools.com/python/pandas_intro.asp"
                ),
                DayTask(
                    title = "Pandas Practice",
                    whatToDo = "Filter, sort, and analyze a dataset.",
                    whyThisMatters = "Real-world data is messy.",
                    resourceUrl = "https://www.kaggle.com/learn/pandas"
                )
            )

            in 41..45 -> listOf(
                DayTask(
                    title = "Data Cleaning Basics",
                    whatToDo = "Handle missing and duplicate data.",
                    whyThisMatters = "Clean data = better ML results.",
                    resourceUrl = "https://www.geeksforgeeks.org/data-preprocessing-machine-learning/"
                ),
                DayTask(
                    title = "Practice Data Cleaning",
                    whatToDo = "Clean a small dataset manually.",
                    whyThisMatters = "This is a real ML engineer skill.",
                    resourceUrl = "https://www.kaggle.com/learn/data-cleaning"
                )
            )

            in 46..50 -> listOf(
                DayTask(
                    title = "Data Visualization",
                    whatToDo = "Learn basic plots using Matplotlib.",
                    whyThisMatters = "Visuals help understand data patterns.",
                    resourceUrl = "https://www.w3schools.com/python/matplotlib_intro.asp"
                ),
                DayTask(
                    title = "Plot Practice",
                    whatToDo = "Create line, bar, and scatter plots.",
                    whyThisMatters = "Every ML project uses visualization.",
                    resourceUrl = "https://www.geeksforgeeks.org/python-matplotlib/"
                )
            )

            in 51..55 -> listOf(
                DayTask(
                    title = "What is Machine Learning?",
                    whatToDo = "Understand supervised vs unsupervised learning.",
                    whyThisMatters = "This is the core ML concept.",
                    resourceUrl = "https://www.geeksforgeeks.org/machine-learning/"
                ),
                DayTask(
                    title = "ML Use Cases",
                    whatToDo = "Study real-life ML applications.",
                    whyThisMatters = "Helps connect ML to real problems.",
                    resourceUrl = "https://www.ibm.com/topics/machine-learning"
                )
            )

            in 56..60 -> listOf(
                DayTask(
                    title = "Linear Regression",
                    whatToDo = "Learn how prediction works.",
                    whyThisMatters = "This is the simplest ML model.",
                    resourceUrl = "https://www.geeksforgeeks.org/linear-regression-python-implementation/"
                ),
                DayTask(
                    title = "Regression Practice",
                    whatToDo = "Build a simple regression model.",
                    whyThisMatters = "Hands-on beats theory.",
                    resourceUrl = "https://www.kaggle.com/learn/intro-to-machine-learning"
                )
            )

            in 61..65 -> listOf(
                DayTask(
                    title = "Classification Basics",
                    whatToDo = "Understand classification problems.",
                    whyThisMatters = "Used in spam detection & diagnosis.",
                    resourceUrl = "https://www.geeksforgeeks.org/classification-algorithms/"
                ),
                DayTask(
                    title = "KNN Algorithm",
                    whatToDo = "Learn K-Nearest Neighbors.",
                    whyThisMatters = "Simple but powerful ML algorithm.",
                    resourceUrl = "https://www.geeksforgeeks.org/k-nearest-neighbors-algorithm/"
                )
            )

            in 66..70 -> listOf(
                DayTask(
                    title = "Train-Test Split",
                    whatToDo = "Understand training vs testing data.",
                    whyThisMatters = "Prevents overfitting.",
                    resourceUrl = "https://www.geeksforgeeks.org/train-test-split-in-machine-learning/"
                ),
                DayTask(
                    title = "Model Evaluation",
                    whatToDo = "Learn accuracy and confusion matrix.",
                    whyThisMatters = "Measures model performance.",
                    resourceUrl = "https://www.geeksforgeeks.org/confusion-matrix-machine-learning/"
                )
            )

            in 71..75 -> listOf(
                DayTask(
                    title = "Overfitting & Underfitting",
                    whatToDo = "Understand model mistakes.",
                    whyThisMatters = "Critical ML concept.",
                    resourceUrl = "https://www.geeksforgeeks.org/underfitting-and-overfitting-in-machine-learning/"
                ),
                DayTask(
                    title = "Bias vs Variance",
                    whatToDo = "Learn bias-variance tradeoff.",
                    whyThisMatters = "Improves model decisions.",
                    resourceUrl = "https://www.geeksforgeeks.org/bias-variance-tradeoff/"
                )
            )

            in 76..80 -> listOf(
                DayTask(
                    title = "Feature Engineering",
                    whatToDo = "Learn how features affect ML.",
                    whyThisMatters = "Good features = good models.",
                    resourceUrl = "https://www.geeksforgeeks.org/feature-engineering-machine-learning/"
                ),
                DayTask(
                    title = "Feature Practice",
                    whatToDo = "Improve features in a dataset.",
                    whyThisMatters = "Industry-level ML skill.",
                    resourceUrl = "https://www.kaggle.com/learn/feature-engineering"
                )
            )

            in 81..85 -> listOf(
                DayTask(
                    title = "Mini ML Project Idea",
                    whatToDo = "Choose a simple ML problem.",
                    whyThisMatters = "Projects prove your skills.",
                    resourceUrl = "https://www.kaggle.com/datasets"
                ),
                DayTask(
                    title = "Project Planning",
                    whatToDo = "Define data, goal, and output.",
                    whyThisMatters = "Planning prevents confusion.",
                    resourceUrl = "https://towardsdatascience.com/ml-project-checklist-1f0b70f04c7a"
                )
            )

            in 86..90 -> listOf(
                DayTask(
                    title = "Build Mini Project",
                    whatToDo = "Train and test your ML model.",
                    whyThisMatters = "This is real ML work.",
                    resourceUrl = "https://www.kaggle.com/learn/intro-to-machine-learning"
                ),
                DayTask(
                    title = "Explain Your Model",
                    whatToDo = "Explain project in simple words.",
                    whyThisMatters = "Interviewers test clarity.",
                    resourceUrl = "https://www.interviewbit.com/machine-learning-interview-questions/"
                )
            )



            else -> listOf(
                DayTask(
                    title = "Locked",
                    whatToDo = "Complete previous days to unlock.",
                    whyThisMatters = "Consistency beats speed.",
                    resourceUrl = "https://www.google.com"
                )
            )
        }
    }
}
