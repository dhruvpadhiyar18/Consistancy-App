package com.consistancy.app

object DayTaskProvider {

    fun getTasksForDay(day: Int): List<DayTask> {
        return when (day) {

            1 -> listOf(
                DayTask(
                    title = "Introduction to Programming & Python",
                    whatToDo = "Understand what programming is and why Python dominates AI/ML. Watch the first 45 minutes of the tutorial.",
                    whyThisMatters = "Programming enables logical thinking. Python is the #1 language for AI, machine learning, and automation.",
                    resourceUrl = "https://www.youtube.com/watch?v=rfscVS0vtbw"
                ),
                DayTask(
                    title = "Problem-Solving Mindset",
                    whatToDo = "Learn the 5-step problem-solving approach: Understand → Plan → Code → Test → Optimize.",
                    whyThisMatters = "Syntax is secondary. Thinking clearly is what separates average coders from great engineers.",
                    resourceUrl = "https://www.geeksforgeeks.org/how-to-approach-a-coding-problem/"
                )
            )

            2 -> listOf(
                    DayTask(
                        title = "Variables & Data Types",
                        whatToDo = "Learn int, float, string, boolean with real-world examples. Create 5 variables for different data types.",
                        whyThisMatters = "All programs process data. Mastering data types is the foundation of every algorithm.",
                        resourceUrl = "https://www.w3schools.com/python/python_variables.asp"
                    ),
                    DayTask(
                        title = "Execution Flow Understanding",
                        whatToDo = "Trace how Python reads and executes code line by line. Use print() to debug.",
                        whyThisMatters = "Understanding execution flow removes 80% of beginner debugging confusion.",
                        resourceUrl = "https://runestone.academy/ns/books/published/thinkcspy/Functions/FlowofExecutionSummary.html"
                    )
                )

            3 -> listOf(
                    DayTask(
                        title = "Control Flow: If/Else Statements",
                        whatToDo = "Master conditional logic: if, elif, else. Build decision-making code.",
                        whyThisMatters = "Every program depends on conditions. This enables dynamic behavior.",
                        resourceUrl = "https://www.w3schools.com/python/python_conditions.asp"
                    ),
                    DayTask(
                        title = "Logic Practice: Decision Making",
                        whatToDo = "Solve 5 conditional problems: age check, grade calculator, discount logic.",
                        whyThisMatters = "Logic practice builds clarity and debugging confidence.",
                        resourceUrl = "https://www.hackerrank.com/domains/python"
                    )
                )

            4 -> listOf(
                    DayTask(
                        title = "Loops: For & While",
                        whatToDo = "Learn loop mechanics: for-loops for iteration, while-loops for conditions.",
                        whyThisMatters = "Loops automate repetitive tasks. Essential for processing large datasets.",
                        resourceUrl = "https://www.w3schools.com/python/python_for_loops.asp"
                    ),
                    DayTask(
                        title = "Loop Application Practice",
                        whatToDo = "Print patterns, number sequences, and generate tables using loops.",
                        whyThisMatters = "Loop mastery is critical for data processing in ML.",
                        resourceUrl = "https://www.geeksforgeeks.org/loops-in-python/"
                    )
                )

            5 -> listOf(
                    DayTask(
                        title = "Functions: Definition & Reusability",
                        whatToDo = "Learn function syntax: def, parameters, return statements. Write 3 functions.",
                        whyThisMatters = "Functions keep code clean, reusable, and maintainable. Essential for ML pipelines.",
                        resourceUrl = "https://www.w3schools.com/python/python_functions.asp"
                    ),
                    DayTask(
                        title = "Function Design Practice",
                        whatToDo = "Write functions: calculate_average(), check_palindrome(), sum_digits().",
                        whyThisMatters = "Modular thinking prevents code duplication and aids debugging.",
                        resourceUrl = "https://realpython.com/defining-your-own-python-function/"
                    )
                )

            6 -> listOf(
                    DayTask(
                        title = "Lists: Creation & Operations",
                        whatToDo = "Learn list indexing (0-based), slicing, append, remove, sort.",
                        whyThisMatters = "Lists are the most common data structure. Essential for datasets.",
                        resourceUrl = "https://www.w3schools.com/python/python_lists.asp"
                    ),
                    DayTask(
                        title = "List Manipulation Challenges",
                        whatToDo = "Solve 5 list problems: find max, reverse, remove duplicates.",
                        whyThisMatters = "List skills prepare you for data structure algorithms (DSA).",
                        resourceUrl = "https://leetcode.com/explore/learn/card/array-and-string/"
                    )
                )

            7 -> listOf(
                    DayTask(
                        title = "Tuples & Sets: Immutable & Unique Collections",
                        whatToDo = "Understand immutability (tuples), uniqueness (sets), and their use cases.",
                        whyThisMatters = "Tuples ensure data integrity. Sets enable fast lookups (O(1) average).",
                        resourceUrl = "https://www.w3schools.com/python/python_tuples.asp"
                    ),
                    DayTask(
                        title = "Collection Type Practice",
                        whatToDo = "Convert between lists, tuples, sets. Find intersections and unions.",
                        whyThisMatters = "Real-world data requires choosing the right collection type.",
                        resourceUrl = "https://www.geeksforgeeks.org/python-collections-module/"
                    )
                )

            8 -> listOf(
                    DayTask(
                        title = "Dictionaries: Key-Value Data Structures",
                        whatToDo = "Master dict creation, access, update, iterate. Build a simple contact book.",
                        whyThisMatters = "Dictionaries enable fast lookups. Used everywhere in backend & AI systems.",
                        resourceUrl = "https://www.w3schools.com/python/python_dictionaries.asp"
                    ),
                    DayTask(
                        title = "Dictionary Application Practice",
                        whatToDo = "Create a student grades system, phone directory, word frequency counter.",
                        whyThisMatters = "Dictionaries model real-world relationships in ML feature extraction.",
                        resourceUrl = "https://realpython.com/python-dicts/"
                    )
                )

            9 -> listOf(
                    DayTask(
                        title = "Introduction to Data Structures & Algorithms (DSA)",
                        whatToDo = "Understand what data structures are and why they matter for efficiency.",
                        whyThisMatters = "Good DSA skills = efficient solutions. Critical for interviews & ML optimization.",
                        resourceUrl = "https://www.geeksforgeeks.org/data-structures/"
                    ),
                    DayTask(
                        title = "Time Complexity & Big-O Notation",
                        whatToDo = "Learn Big-O basics: O(1), O(n), O(n²). Analyze simple algorithms.",
                        whyThisMatters = "Efficiency matters in interviews and production ML systems.",
                        resourceUrl = "https://www.geeksforgeeks.org/analysis-of-algorithms-set-1-asymptotic-analysis/"
                    )
                )

            10 -> listOf(
                    DayTask(
                        title = "Arrays & String Fundamentals",
                        whatToDo = "Learn array traversal, indexing, slicing. Understand string as array of characters.",
                        whyThisMatters = "Arrays are the core DSA structure. 60% of interview problems use arrays.",
                        resourceUrl = "https://leetcode.com/explore/learn/card/array-and-string/"
                    ),
                    DayTask(
                        title = "Array Problem Solving",
                        whatToDo = "Solve 3 easy array problems: find max, reverse, check duplicates.",
                        whyThisMatters = "Array problems build foundation for advanced algorithms.",
                        resourceUrl = "https://leetcode.com/problemset/all/?difficulty=EASY&topicTags=Array"
                    )
                )

                // ===== DAYS 11-30: Advanced Python & DSA =====
            in 11..20 -> listOf(
                    DayTask(
                        title = "Daily DSA Practice: Arrays & Strings",
                        whatToDo = "Solve 2-3 problems from arrays/strings. Focus on approach, not just code.",
                        whyThisMatters = "Daily practice builds mastery. Consistency matters more than speed.",
                        resourceUrl = "https://leetcode.com/explore/learn/card/array-and-string/"
                    ),
                    DayTask(
                        title = "Python Fundamentals Revision",
                        whatToDo = "Review functions, lists, dicts, loops. Fix any weak areas.",
                        whyThisMatters = "Strong Python basics = exponential growth in learning speed.",
                        resourceUrl = "https://www.w3schools.com/python/"
                    )
                )

            in 21..30 -> listOf(
                    DayTask(
                        title = "Advanced DSA: Searching & Sorting",
                        whatToDo = "Learn binary search, merge sort, quick sort. Understand time/space tradeoffs.",
                        whyThisMatters = "Interview essential topics. Foundation for optimization algorithms.",
                        resourceUrl = "https://www.geeksforgeeks.org/searching-algorithms/"
                    ),
                    DayTask(
                        title = "Problem-Solving Mastery",
                        whatToDo = "Solve 3+ problems daily. Document your approach in comments.",
                        whyThisMatters = "Consistency builds neural pathways. Document = Learn faster.",
                        resourceUrl = "https://leetcode.com/problemset/all/"
                    )
                )

                // ===== PHASE 2: MACHINE LEARNING (Days 31-90) =====
                // ML foundations, statistics, data science tools

            in 31..35 -> listOf(
                    DayTask(
                        title = "NumPy: The Foundation of Numerical Computing",
                        whatToDo = "Learn NumPy arrays, operations, broadcasting. Create and manipulate arrays.",
                        whyThisMatters = "NumPy is the foundation of ALL ML computations. 99% of ML uses NumPy.",
                        resourceUrl = "https://www.w3schools.com/python/numpy_intro.asp"
                    ),
                    DayTask(
                        title = "NumPy Mastery Practice",
                        whatToDo = "Create arrays, perform operations, understand broadcasting.",
                        whyThisMatters = "ML models work on numerical data. NumPy efficiency = faster training.",
                        resourceUrl = "https://numpy.org/doc/stable/user/basics.html"
                    )
                )

            in 36..40 -> listOf(
                    DayTask(
                        title = "Pandas: Data Manipulation & Analysis",
                        whatToDo = "Learn DataFrames, reading CSV, filtering, grouping, merging.",
                        whyThisMatters = "80% of ML work is data cleaning & preprocessing. Pandas is essential.",
                        resourceUrl = "https://www.learndatasci.com/tutorials/python-pandas-tutorial-complete-introduction-for-beginners/"
                    ),
                    DayTask(
                        title = "Real Data Analysis Practice",
                        whatToDo = "Load a dataset, explore it, clean it, answer data questions.",
                        whyThisMatters = "Real-world data is messy. Pandas skills = production-ready engineer.",
                        resourceUrl = "https://www.kaggle.com/learn/pandas"
                    )
                )

            in 41..45 -> listOf(
                    DayTask(
                        title = "Data Cleaning & Preprocessing",
                        whatToDo = "Handle missing values, duplicates, outliers, categorical encoding.",
                        whyThisMatters = "Clean data = better ML results. 70% of ML success is data quality.",
                        resourceUrl = "https://builtin.com/machine-learning/how-to-preprocess-data-python"
                    ),
                    DayTask(
                        title = "Cleaning Real Datasets",
                        whatToDo = "Clean a small real dataset. Document your decisions.",
                        whyThisMatters = "This is a production ML engineer skill. Document your approach.",
                        resourceUrl = "https://www.kaggle.com/learn/data-cleaning"
                    )
                )

            in 46..50 -> listOf(
                    DayTask(
                        title = "Data Visualization Fundamentals",
                        whatToDo = "Learn Matplotlib basics: line, bar, scatter plots, histograms.",
                        whyThisMatters = "Visuals help understand patterns. Every ML project uses visualization.",
                        resourceUrl = "https://www.w3schools.com/python/matplotlib_intro.asp"
                    ),
                    DayTask(
                        title = "Visualization Practice",
                        whatToDo = "Create line, bar, scatter, histogram plots. Tell a story with data.",
                        whyThisMatters = "Visualization skills are crucial for presenting ML insights to stakeholders.",
                        resourceUrl = "https://www.datacamp.com/tutorial/matplotlib-tutorial-python"
                    )
                )

            in 51..55 -> listOf(
                    DayTask(
                        title = "Machine Learning Fundamentals",
                        whatToDo = "Understand supervised vs unsupervised learning. Classification vs regression.",
                        whyThisMatters = "This is THE core ML concept. Separates data scientists from engineers.",
                        resourceUrl = "https://www.geeksforgeeks.org/machine-learning/"
                    ),
                    DayTask(
                        title = "Real ML Use Cases",
                        whatToDo = "Study 5 real-world ML applications. Identify which type (supervised/unsupervised).",
                        whyThisMatters = "Understanding practical applications makes theory stick.",
                        resourceUrl = "https://www.datacamp.com/blog/top-machine-learning-use-cases-and-algorithms"
                    )
                )

            in 56..60 -> listOf(
                    DayTask(
                        title = "Statistics Essentials for ML",
                        whatToDo = "Learn mean, median, mode, standard deviation, distributions, hypothesis testing.",
                        whyThisMatters = "Statistics is the language of ML. Understand data properties deeply.",
                        resourceUrl = "https://www.coursera.org/learn/machine-learning-probability-and-statistics"
                    ),
                    DayTask(
                        title = "Statistical Analysis Practice",
                        whatToDo = "Analyze distributions, calculate statistics, test hypotheses on real data.",
                        whyThisMatters = "Statistical rigor prevents overconfidence in ML models.",
                        resourceUrl = "https://www.khanacademy.org/math/statistics-probability"
                    )
                )

            in 61..65 -> listOf(
                    DayTask(
                        title = "Regression: Predicting Continuous Values",
                        whatToDo = "Learn linear regression, evaluate with R², MSE, RMSE.",
                        whyThisMatters = "Regression is foundational ML. Used in pricing, forecasting, recommendations.",
                        resourceUrl = "https://www.geeksforgeeks.org/linear-regression-python-implementation/"
                    ),
                    DayTask(
                        title = "Regression Implementation",
                        whatToDo = "Build a linear regression model. Evaluate performance. Visualize results.",
                        whyThisMatters = "Hands-on coding solidifies understanding.",
                        resourceUrl = "https://scikit-learn.org/stable/modules/generated/sklearn.linear_model.LinearRegression.html"
                    )
                )

            in 66..70 -> listOf(
                    DayTask(
                        title = "Classification: Predicting Categories",
                        whatToDo = "Learn logistic regression, decision trees, evaluate with accuracy, precision, recall.",
                        whyThisMatters = "Classification is used in spam detection, disease diagnosis, fraud detection.",
                        resourceUrl = "https://www.justintodata.com/logistic-regression-example-in-python/"
                    ),
                    DayTask(
                        title = "Classification Model Building",
                        whatToDo = "Build a classifier. Evaluate confusion matrix. Understand precision vs recall.",
                        whyThisMatters = "Understanding metrics prevents building useless models.",
                        resourceUrl = "https://scikit-learn.org/stable/modules/ensemble.html#classification"
                    )
                )

            in 71..75 -> listOf(
                    DayTask(
                        title = "Feature Engineering & Selection",
                        whatToDo = "Learn scaling, normalization, encoding, feature selection techniques.",
                        whyThisMatters = "Good features > Good algorithms. This is where real ML value comes from.",
                        resourceUrl = "https://www.freecodecamp.org/news/feature-engineering-techniques-for-structured-data/"
                    ),
                    DayTask(
                        title = "Engineering Features from Data",
                        whatToDo = "Create meaningful features. Scale/normalize data. Reduce dimensionality.",
                        whyThisMatters = "Feature engineering separates good models from great ones.",
                        resourceUrl = "https://scikit-learn.org/stable/modules/preprocessing.html"
                    )
                )

            in 76..80 -> listOf(
                    DayTask(
                        title = "Model Evaluation & Validation",
                        whatToDo = "Learn cross-validation, train-test split, overfitting, underfitting.",
                        whyThisMatters = "Proper evaluation prevents fooling yourself. This is a critical skill.",
                        resourceUrl = "https://www.geeksforgeeks.org/cross-validation-machine-learning/"
                    ),
                    DayTask(
                        title = "Validation Practice",
                        whatToDo = "Implement k-fold cross-validation. Check for overfitting.",
                        whyThisMatters = "Rigorous validation = production-ready models.",
                        resourceUrl = "https://scikit-learn.org/stable/modules/cross_validation.html"
                    )
                )

            in 81..85 -> listOf(
                    DayTask(
                        title = "Unsupervised Learning: Clustering",
                        whatToDo = "Learn K-means, hierarchical clustering, evaluate with silhouette score.",
                        whyThisMatters = "Clustering finds hidden patterns. Used in customer segmentation, recommendation systems.",
                        resourceUrl = "https://www.geeksforgeeks.org/clustering-in-machine-learning/"
                    ),
                    DayTask(
                        title = "Clustering Implementation",
                        whatToDo = "Apply K-means to a dataset. Visualize clusters. Find optimal k.",
                        whyThisMatters = "Clustering unlocks business insights from unlabeled data.",
                        resourceUrl = "https://scikit-learn.org/stable/modules/clustering.html"
                    )
                )

            in 86..90 -> listOf(
                    DayTask(
                        title = "Ensemble Methods: Combining Models",
                        whatToDo = "Learn Random Forest, Gradient Boosting, bagging, boosting concepts.",
                        whyThisMatters = "Ensemble methods win 90% of Kaggle competitions. Most powerful ML technique.",
                        resourceUrl = "https://www.geeksforgeeks.org/ensemble-methods-in-machine-learning/"
                    ),
                    DayTask(
                        title = "Ensemble Model Building",
                        whatToDo = "Build Random Forest & XGBoost models. Compare performance.",
                        whyThisMatters = "Ensembles dramatically improve accuracy. Industry standard.",
                        resourceUrl = "https://scikit-learn.org/stable/modules/ensemble.html"
                    )
                )

                // ===== PHASE 3: DEEP LEARNING (Days 91-150) =====
                // Neural networks, CNNs, RNNs, LLMs

            in 91..95 -> listOf(
                    DayTask(
                        title = "Neural Networks Fundamentals",
                        whatToDo = "Understand neurons, layers, activation functions, forward propagation.",
                        whyThisMatters = "Deep learning powers modern AI. Neural networks are the foundation.",
                        resourceUrl = "https://www.youtube.com/watch?v=KiW-W4v0nBo"
                    ),
                    DayTask(
                        title = "Neural Network Intuition",
                        whatToDo = "Learn how neurons learn through backpropagation. Understand optimization.",
                        whyThisMatters = "Intuition prevents treating DL as black box. Build confidence.",
                        resourceUrl = "https://playground.tensorflow.org/"
                    )
                )

            in 96..100 -> listOf(
                    DayTask(
                        title = "Deep Learning with TensorFlow & Keras",
                        whatToDo = "Learn Keras API. Build your first neural network on MNIST dataset.",
                        whyThisMatters = "Keras is the most intuitive DL framework. Industry standard for prototyping.",
                        resourceUrl = "https://www.tensorflow.org/tutorials/keras/classification"
                    ),
                    DayTask(
                        title = "First Deep Learning Model",
                        whatToDo = "Build & train a neural network. Achieve 95%+ accuracy on MNIST.",
                        whyThisMatters = "Your first DL model builds momentum. Success breeds confidence.",
                        resourceUrl = "https://keras.io/"
                    )
                )

            in 101..105 -> listOf(
                    DayTask(
                        title = "Convolutional Neural Networks (CNNs)",
                        whatToDo = "Learn convolution, pooling, feature maps. Build a CNN from scratch.",
                        whyThisMatters = "CNNs are the gold standard for computer vision. Powers image recognition.",
                        resourceUrl = "https://www.simplilearn.com/tutorials/deep-learning-tutorial/convolutional-neural-network"
                    ),
                    DayTask(
                        title = "CNN Image Classification",
                        whatToDo = "Build CNN for CIFAR-10. Understand why convolution works.",
                        whyThisMatters = "Computer vision skills are highly marketable.",
                        resourceUrl = "https://www.tensorflow.org/tutorials/images/cnn"
                    )
                )

            in 106..110 -> listOf(
                    DayTask(
                        title = "Recurrent Neural Networks (RNNs) & LSTMs",
                        whatToDo = "Learn sequence modeling, LSTM cells, gate mechanisms.",
                        whyThisMatters = "RNNs power NLP, time series, and language models. Foundation for LLMs.",
                        resourceUrl = "https://www.geeksforgeeks.org/introduction-to-recurrent-neural-network/"
                    ),
                    DayTask(
                        title = "Sequence Modeling Project",
                        whatToDo = "Build LSTM for time series prediction or text generation.",
                        whyThisMatters = "Sequence modeling is crucial for real-world applications.",
                        resourceUrl = "https://www.tensorflow.org/tutorials/structured_data/time_series"
                    )
                )

            in 111..115 -> listOf(
                    DayTask(
                        title = "Transfer Learning & Pre-trained Models",
                        whatToDo = "Learn how to fine-tune models like ResNet, VGG, BERT.",
                        whyThisMatters = "Transfer learning = 80% less data needed. State-of-the-art with minimal effort.",
                        resourceUrl = "https://www.tensorflow.org/tutorials/images/transfer_learning"
                    ),
                    DayTask(
                        title = "Transfer Learning Application",
                        whatToDo = "Fine-tune a pre-trained model on a custom dataset.",
                        whyThisMatters = "Transfer learning is used in 90% of real-world DL projects.",
                        resourceUrl = "https://www.tensorflow.org/tutorials/images/transfer_learning"
                    )
                )

            in 116..120 -> listOf(
                    DayTask(
                        title = "Natural Language Processing (NLP) Basics",
                        whatToDo = "Learn tokenization, embeddings, sentiment analysis, text classification.",
                        whyThisMatters = "NLP powers chatbots, search engines, content recommendation.",
                        resourceUrl = "https://www.geeksforgeeks.org/natural-language-processing-nlp-tutorial/"
                    ),
                    DayTask(
                        title = "Text Classification Model",
                        whatToDo = "Build sentiment analysis or spam detection model.",
                        whyThisMatters = "NLP skills are highly in-demand across tech companies.",
                        resourceUrl = "https://www.tensorflow.org/tutorials/text/text_classification_rnn"
                    )
                )

            in 121..125 -> listOf(
                    DayTask(
                        title = "Attention Mechanisms & Transformers",
                        whatToDo = "Understand self-attention, multi-head attention, transformer architecture.",
                        whyThisMatters = "Transformers power GPT, BERT, all modern LLMs. This is cutting-edge AI.",
                        resourceUrl = "https://jalammar.github.io/illustrated-transformer/"
                    ),
                    DayTask(
                        title = "Transformer Intuition",
                        whatToDo = "Learn the Attention is All You Need paper. Understand why it works.",
                        whyThisMatters = "Understanding transformers is essential for modern AI engineering.",
                        resourceUrl = "https://arxiv.org/abs/1706.03762"
                    )
                )

            in 126..130 -> listOf(
                    DayTask(
                        title = "Large Language Models (LLMs) Fundamentals",
                        whatToDo = "Learn about GPT, BERT, fine-tuning, prompting strategies.",
                        whyThisMatters = "LLMs power ChatGPT, search engines. Critical career skill.",
                        resourceUrl = "https://www.freecodecamp.org/news/a-beginners-guide-to-large-language-models/"
                    ),
                    DayTask(
                        title = "Working with LLMs",
                        whatToDo = "Use OpenAI API or Hugging Face models. Build an LLM application.",
                        whyThisMatters = "LLM skills are immediately marketable and in high demand.",
                        resourceUrl = "https://huggingface.co/"
                    )
                )

            in 131..135 -> listOf(
                    DayTask(
                        title = "Generative AI & Diffusion Models",
                        whatToDo = "Learn VAEs, GANs, diffusion models, image generation.",
                        whyThisMatters = "Powers DALL-E, Stable Diffusion. Hottest AI field.",
                        resourceUrl = "https://www.tutorialspoint.com/gen-ai/index.htm"
                    ),
                    DayTask(
                        title = "Building with Generative Models",
                        whatToDo = "Experiment with stable diffusion or other generative models.",
                        whyThisMatters = "Generative AI is the hottest area in AI right now.",
                        resourceUrl = "https://github.com/replicate/replicate"
                    )
                )

            in 136..140 -> listOf(
                    DayTask(
                        title = "Reinforcement Learning Basics",
                        whatToDo = "Learn Markov Decision Processes, Q-learning, policy gradient.",
                        whyThisMatters = "Powers robotics, game AI. Emerging $; 1B field.",
                        resourceUrl = "https://www.tutorialspoint.com/machine_learning/machine_learning_reinforcement_learning.htm"
                    ),
                    DayTask(
                        title = "RL Agent Project",
                        whatToDo = "Build a Q-learning agent or train with stable-baselines3.",
                        whyThisMatters = "RL skills differentiate you from typical ML engineers.",
                        resourceUrl = "https://stable-baselines3.readthedocs.io/"
                    )
                )

            in 141..145 -> listOf(
                    DayTask(
                        title = "Model Optimization & Production",
                        whatToDo = "Learn quantization, pruning, distillation, inference optimization.",
                        whyThisMatters = "Optimization = faster inference = lower costs. Critical for production.",
                        resourceUrl = "https://www.geeksforgeeks.org/deep-learning/tensorflow-model-optimization/"
                    ),
                    DayTask(
                        title = "Deploy an Optimized Model",
                        whatToDo = "Optimize a model, compress it, measure latency improvements.",
                        whyThisMatters = "Deployment skills bridge gap between research and industry.",
                        resourceUrl = "https://www.tensorflow.org/lite"
                    )
                )

            in 146..150 -> listOf(
                    DayTask(
                        title = "Ethics, Bias, & Responsible AI",
                        whatToDo = "Learn about bias detection, fairness metrics, responsible AI principles.",
                        whyThisMatters = "Ethical AI is non-negotiable. Increasingly required by industry.",
                        resourceUrl = "https://www.geeksforgeeks.org/artificial-intelligence/ai-ethics"
                    ),
                    DayTask(
                        title = "Building Fair Models",
                        whatToDo = "Audit a model for bias. Implement fairness improvements.",
                        whyThisMatters = "Responsible AI is the future of ML engineering.",
                        resourceUrl = "https://www.tensorflow.org/responsible_ai"
                    )
                )

                // ===== PHASE 4: CAREER READY (Days 151-180) =====
                // Portfolio projects, interview prep, real-world applications

            in 151..155 -> listOf(
                    DayTask(
                        title = "Building Your ML Portfolio Project 1",
                        whatToDo = "Define a problem, collect data, build end-to-end ML pipeline.",
                        whyThisMatters = "Portfolio projects are what land you jobs. Make them impressive.",
                        resourceUrl = "https://www.kaggle.com/datasets"
                    ),
                    DayTask(
                        title = "Portfolio Project Development",
                        whatToDo = "Build a complete project: EDA → Model → Evaluation → Deployment.",
                        whyThisMatters = "Real projects > Theory. This is what employers want to see.",
                        resourceUrl = "https://github.com/topics/machine-learning-projects"
                    )
                )

            in 156..160 -> listOf(
                    DayTask(
                        title = "Advanced: MLOps & Model Deployment",
                        whatToDo = "Learn Docker, CI/CD, model versioning, monitoring.",
                        whyThisMatters = "MLOps is the new frontier. Critical for production systems.",
                        resourceUrl = "https://github.com/GokuMohandas/mlops-course"
                    ),
                    DayTask(
                        title = "Deploy to Production",
                        whatToDo = "Deploy a model using Docker, FastAPI, or AWS/GCP.",
                        whyThisMatters = "MLOps engineers earn 30-40% more than regular ML engineers.",
                        resourceUrl = "https://cloud.google.com/ai-platform/docs"
                    )
                )

            in 161..165 -> listOf(
                    DayTask(
                        title = "Data Engineering for ML",
                        whatToDo = "Learn SQL, data pipelines, Apache Spark, data warehousing.",
                        whyThisMatters = "Data pipelines are critical. Most ML time spent on data, not modeling.",
                        resourceUrl = "https://www.geeksforgeeks.org/machine-learning/machine-learning/"
                    ),
                    DayTask(
                        title = "Building Data Pipelines",
                        whatToDo = "Build an ETL pipeline or batch processing system.",
                        whyThisMatters = "Full-stack ML skills make you invaluable.",
                        resourceUrl = "https://airflow.apache.org/"
                    )
                )

            in 166..170 -> listOf(
                    DayTask(
                        title = "Interview Preparation: Technical Round",
                        whatToDo = "Practice coding + ML theory questions. Do mock interviews.",
                        whyThisMatters = "Interviews test problem-solving, not memorization. Practice is key.",
                        resourceUrl = "https://www.geeksforgeeks.org/machine-learning-interview-questions/"
                    ),
                    DayTask(
                        title = "Mock Interview Practice",
                        whatToDo = "Do 3 mock interviews on Pramp or with friends.",
                        whyThisMatters = "Practice interviews reduce anxiety and improve performance.",
                        resourceUrl = "https://www.pramp.com/"
                    )
                )

            in 171..175 -> listOf(
                    DayTask(
                        title = "System Design for ML",
                        whatToDo = "Learn to design ML systems at scale. Study real systems.",
                        whyThisMatters = "System design separates junior from senior roles. Worth $40k/year salary premium.",
                        resourceUrl = "https://www.geeksforgeeks.org/system-design/system-design-in-machine-learning/"
                    ),
                    DayTask(
                        title = "Design Practice",
                        whatToDo = "Design a recommendation system, fraud detection, or prediction system.",
                        whyThisMatters = "System design interviews are make-or-break.",
                        resourceUrl = "https://github.com/chiphuyen/machine-learning-systems-design"
                    )
                )

            in 176..180 -> listOf(
                    DayTask(
                        title = "Capstone: End-to-End AI Project",
                        whatToDo = "Follow Kaggle competition: EDA → Feature Engineering → Model → Evaluation → Submission",
                        whyThisMatters = "Real ML competition experience. Portfolio gold.",
                        resourceUrl = "https://www.kaggle.com/code/alexisbcook/machine-learning-competitions/notebook"
                    ),
                    DayTask(
                        title = "Portfolio Showcase & Job Ready",
                        whatToDo = "Clean code, write documentation, create compelling GitHub README.",
                        whyThisMatters = "Presentation matters. First impression = portfolio quality.",
                        resourceUrl = "https://www.makeareadme.com/"
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
