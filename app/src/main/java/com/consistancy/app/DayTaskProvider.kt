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
                    whatToDo = "Learn how to think step-by-step before coding.",
                    whyThisMatters = "Good thinking matters more than syntax.",
                    resourceUrl = "https://www.youtube.com/watch?v=RkzTN4Yy5Js"
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
                    title = "Control Flow (if / else)",
                    whatToDo = "Learn conditional statements and simple decision making.",
                    whyThisMatters = "Every program depends on conditions and choices.",
                    resourceUrl = "https://www.w3schools.com/python/python_conditions.asp"
                ),
                DayTask(
                    title = "Practice Logic",
                    whatToDo = "Solve 5 simple if-else problems.",
                    whyThisMatters = "Logic improves clarity and confidence.",
                    resourceUrl = "https://www.hackerrank.com/domains/tutorials/10-days-of-python"
                )
            )

            4 -> listOf(
                DayTask(
                    title = "Loops (for / while)",
                    whatToDo = "Understand looping concepts with examples.",
                    whyThisMatters = "Loops automate repetitive work.",
                    resourceUrl = "https://www.w3schools.com/python/python_loops.asp"
                ),
                DayTask(
                    title = "Loop Practice",
                    whatToDo = "Print patterns and number sequences.",
                    whyThisMatters = "Builds thinking speed.",
                    resourceUrl = "https://www.geeksforgeeks.org/loops-in-python/"
                )
            )

            5 -> listOf(
                DayTask(
                    title = "Functions Basics",
                    whatToDo = "Learn how to define and call functions.",
                    whyThisMatters = "Functions keep code clean and reusable.",
                    resourceUrl = "https://www.w3schools.com/python/python_functions.asp"
                ),
                DayTask(
                    title = "Function Practice",
                    whatToDo = "Write 3 small functions.",
                    whyThisMatters = "Modular thinking is essential.",
                    resourceUrl = "https://realpython.com/defining-your-own-python-function/"
                )
            )

            6 -> listOf(
                DayTask(
                    title = "Lists in Python",
                    whatToDo = "Learn list creation, indexing, and operations.",
                    whyThisMatters = "Lists store and manage data efficiently.",
                    resourceUrl = "https://www.w3schools.com/python/python_lists.asp"
                ),
                DayTask(
                    title = "List Problems",
                    whatToDo = "Solve 5 list-based problems.",
                    whyThisMatters = "Prepares for DSA.",
                    resourceUrl = "https://leetcode.com/tag/array/"
                )
            )

            7 -> listOf(
                DayTask(
                    title = "Tuples & Sets",
                    whatToDo = "Understand immutable and unique collections.",
                    whyThisMatters = "Improves data handling.",
                    resourceUrl = "https://www.w3schools.com/python/python_tuples.asp"
                ),
                DayTask(
                    title = "Practice Collections",
                    whatToDo = "Convert lists to sets and tuples.",
                    whyThisMatters = "Strengthens Python basics.",
                    resourceUrl = "https://www.geeksforgeeks.org/python-collections/"
                )
            )

            8 -> listOf(
                DayTask(
                    title = "Dictionaries",
                    whatToDo = "Learn key-value data structures.",
                    whyThisMatters = "Used everywhere in real apps.",
                    resourceUrl = "https://www.w3schools.com/python/python_dictionaries.asp"
                ),
                DayTask(
                    title = "Dictionary Practice",
                    whatToDo = "Create and access dictionary data.",
                    whyThisMatters = "Essential for backend & AI.",
                    resourceUrl = "https://realpython.com/python-dicts/"
                )
            )

            9 -> listOf(
                DayTask(
                    title = "Intro to DSA",
                    whatToDo = "Understand what Data Structures are.",
                    whyThisMatters = "DSA improves problem-solving.",
                    resourceUrl = "https://www.geeksforgeeks.org/data-structures/"
                ),
                DayTask(
                    title = "Time Complexity",
                    whatToDo = "Learn Big-O basics.",
                    whyThisMatters = "Efficiency matters in interviews.",
                    resourceUrl = "https://www.geeksforgeeks.org/analysis-of-algorithms-set-1-asymptotic-analysis/"
                )
            )

            10 -> listOf(
      /*This is box 1's content */          DayTask(
                    title = "Arrays Basics",
                    whatToDo = "Learn array traversal and operations.",
                    whyThisMatters = "Arrays are core DSA structure.",
                    resourceUrl = "https://leetcode.com/explore/learn/card/array-and-string/"
                ),
                /*This is box 2's content */                DayTask(
                    title = "Array Practice",
                    whatToDo = "Solve 3 easy array problems.",
                    whyThisMatters = "Builds confidence for interviews.",
                    resourceUrl = "https://leetcode.com/problemset/all/?difficulty=EASY"
                )
            )

            in 11..20 -> listOf(
                /*This is box 1's content */   DayTask(
                  /*Title*/  title = "DSA Practice",
                    /*what to do*/ whatToDo = "Solve 2–3 problems (arrays / strings).",
                    /*why matter*/whyThisMatters = "Daily practice builds mastery.",
                    /*resourse*/resourceUrl = "https://leetcode.com/tag/string/"
                ),
                /*This is box 2's content */  DayTask(
                    title = "Python Revision",
                    whatToDo = "Revise functions, lists, dicts.",
                    whyThisMatters = "Strong basics = fast growth.",
                    resourceUrl = "https://www.w3schools.com/python/"
                )
            )

            in 21..30 -> listOf(
                DayTask(
                    title = "Advanced DSA Basics",
                    whatToDo = "Learn searching & sorting.",
                    whyThisMatters = "Interview essential topics.",
                    resourceUrl = "https://www.geeksforgeeks.org/searching-algorithms/"
                ),
                DayTask(
                    title = "Problem Solving",
                    whatToDo = "Solve 3 problems daily.",
                    whyThisMatters = "Consistency > speed.",
                    resourceUrl = "https://leetcode.com/problemset/all/"
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

            in 91..95 -> listOf(
                DayTask(
                    "Advanced Regression Models",
                    "Learn Ridge and Lasso regression.",
                    "Used to prevent overfitting in real models.",
                    "https://www.geeksforgeeks.org/regularization-in-machine-learning/"
                ),
                DayTask(
                    "Regression Comparison",
                    "Compare Linear vs Ridge vs Lasso.",
                    "Helps choose correct model.",
                    "https://towardsdatascience.com/ridge-lasso-regression-49a3b64f4c65"
                )
            )

            in 96..100 -> listOf(
                DayTask(
                    "Decision Trees",
                    "Understand how decision trees work.",
                    "Foundation for Random Forest.",
                    "https://www.geeksforgeeks.org/decision-tree/"
                ),
                DayTask(
                    "Tree Visualization",
                    "Visualize a decision tree.",
                    "Visualization builds intuition.",
                    "https://scikit-learn.org/stable/modules/tree.html"
                )
            )

            in 101..105 -> listOf(
                DayTask(
                    "Ensemble Learning",
                    "Learn Random Forest & Boosting.",
                    "Industry uses ensembles heavily.",
                    "https://www.geeksforgeeks.org/ensemble-methods-in-machine-learning/"
                ),
                DayTask(
                    "Model Comparison",
                    "Compare single vs ensemble models.",
                    "Improves accuracy decisions.",
                    "https://www.analyticsvidhya.com/blog/2018/06/comprehensive-guide-for-ensemble-models/"
                )
            )

            in 106..110 -> listOf(
                DayTask(
                    "Neural Network Basics",
                    "Understand neurons, weights, bias.",
                    "Core deep learning foundation.",
                    "https://www.geeksforgeeks.org/neural-networks-a-beginners-guide/"
                ),
                DayTask(
                    "Activation Functions",
                    "Learn ReLU, Sigmoid, Softmax.",
                    "Controls learning behavior.",
                    "https://www.geeksforgeeks.org/activation-functions/"
                )
            )

            in 111..115 -> listOf(
                DayTask(
                    "Intro to TensorFlow / Keras",
                    "Understand deep learning frameworks.",
                    "Industry standard tools.",
                    "https://www.tensorflow.org/tutorials"
                ),
                DayTask(
                    "Build First Neural Network",
                    "Train a simple NN model.",
                    "Hands-on deep learning.",
                    "https://www.tensorflow.org/tutorials/keras/classification"
                )
            )

            in 116..120 -> listOf(
                DayTask(
                    "Overfitting in DL",
                    "Learn dropout & regularization.",
                    "Improves deep model accuracy.",
                    "https://www.geeksforgeeks.org/dropout-in-neural-networks/"
                ),
                DayTask(
                    "Model Tuning",
                    "Tune learning rate and epochs.",
                    "Optimizes training.",
                    "https://keras.io/api/optimizers/"
                )
            )

            in 121..125 -> listOf(
                DayTask(
                    "NLP Basics",
                    "Learn tokenization & text cleaning.",
                    "Text data dominates AI.",
                    "https://www.geeksforgeeks.org/nlp-basics/"
                ),
                DayTask(
                    "Text Processing Practice",
                    "Clean and preprocess text data.",
                    "Essential NLP skill.",
                    "https://www.kaggle.com/learn/natural-language-processing"
                )
            )

            in 126..130 -> listOf(
                DayTask(
                    "Computer Vision Basics",
                    "Understand images as matrices.",
                    "Foundation for CV models.",
                    "https://www.geeksforgeeks.org/introduction-to-computer-vision/"
                ),
                DayTask(
                    "Image Processing",
                    "Load and manipulate images.",
                    "Used in all vision tasks.",
                    "https://docs.opencv.org/"
                )
            )

            in 131..135 -> listOf(
                DayTask(
                    "CNN Concept",
                    "Understand convolutional layers.",
                    "Core of image recognition.",
                    "https://www.geeksforgeeks.org/introduction-convolution-neural-network/"
                ),
                DayTask(
                    "CNN Practice",
                    "Train a simple CNN model.",
                    "Hands-on CV experience.",
                    "https://www.tensorflow.org/tutorials/images/cnn"
                )
            )

            in 136..140 -> listOf(
                DayTask(
                    "What is MLOps?",
                    "Understand ML lifecycle & deployment.",
                    "ML is useless without deployment.",
                    "https://www.geeksforgeeks.org/mlops/"
                ),
                DayTask(
                    "Model Versioning",
                    "Understand model tracking.",
                    "Used in production ML.",
                    "https://mlflow.org/"
                )
            )

            in 141..145 -> listOf(
                DayTask(
                    "API Basics",
                    "Learn how APIs work.",
                    "ML models are served via APIs.",
                    "https://www.geeksforgeeks.org/rest-api-introduction/"
                ),
                DayTask(
                    "Deploy ML Model",
                    "Deploy model using Flask/FastAPI.",
                    "Real-world ML skill.",
                    "https://fastapi.tiangolo.com/tutorial/"
                )
            )

            in 146..150 -> listOf(
                DayTask(
                    "Cloud Basics",
                    "Understand cloud deployment.",
                    "Most ML runs on cloud.",
                    "https://aws.amazon.com/what-is-cloud-computing/"
                ),
                DayTask(
                    "Model Monitoring",
                    "Understand model drift.",
                    "Keeps ML systems reliable.",
                    "https://neptune.ai/blog/model-monitoring"
                )
            )

            in 151..155 -> listOf(
                DayTask(
                    "Major ML Project",
                    "Choose a real-world ML problem.",
                    "Projects matter more than certificates.",
                    "https://www.kaggle.com/"
                ),
                DayTask(
                    "Data Collection",
                    "Gather and clean data.",
                    "Most time spent here.",
                    "https://www.dataquest.io/blog/data-cleaning/"
                )
            )

            in 156..160 -> listOf(
                DayTask(
                    "Model Building",
                    "Train and optimize model.",
                    "Core development phase.",
                    "https://scikit-learn.org/stable/"
                ),
                DayTask(
                    "Model Evaluation",
                    "Test model thoroughly.",
                    "Avoid false confidence.",
                    "https://www.geeksforgeeks.org/confusion-matrix-machine-learning/"
                )
            )

            in 161..165 -> listOf(
                DayTask(
                    "Project Documentation",
                    "Write clear README.",
                    "Recruiters read this.",
                    "https://www.freecodecamp.org/news/how-to-write-a-good-readme-file/"
                ),
                DayTask(
                    "GitHub Publishing",
                    "Push project to GitHub.",
                    "Portfolio proof.",
                    "https://docs.github.com/en/get-started"
                )
            )

            in 166..170 -> listOf(
                DayTask(
                    "AI Interview Questions",
                    "Study common ML interview topics.",
                    "Prepares for job interviews.",
                    "https://www.interviewbit.com/machine-learning-interview-questions/"
                ),
                DayTask(
                    "Explain Projects",
                    "Practice explaining your project.",
                    "Communication matters.",
                    "https://www.youtube.com/watch?v=Z6fSHr5GvK0"
                )
            )

            in 171..175 -> listOf(
                DayTask(
                    "Resume Building",
                    "Create AI-focused resume.",
                    "Resume gets interviews.",
                    "https://www.overleaf.com/latex/templates"
                ),
                DayTask(
                    "LinkedIn Optimization",
                    "Optimize LinkedIn profile.",
                    "Recruiters search here.",
                    "https://www.linkedin.com/help/linkedin"
                )
            )

            in 176..180 -> listOf(
                DayTask(
                    "Mock Interviews",
                    "Practice interview questions.",
                    "Reduces interview fear.",
                    "https://www.pramp.com/"
                ),
                DayTask(
                    "Career Roadmap Review",
                    "Review full 180-day journey.",
                    "Confidence comes from reflection.",
                    "https://roadmap.sh/ai-data-scientist"
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
