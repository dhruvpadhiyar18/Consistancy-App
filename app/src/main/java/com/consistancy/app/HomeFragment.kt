package com.consistancy.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.*
import java.util.concurrent.TimeUnit

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var prefs: android.content.SharedPreferences

    private val quotes = listOf(
        "Consistency is what transforms average into excellence.",
        "Success is the sum of small efforts, repeated day in and day out.",
        "Discipline is doing what needs to be done, even if you don't want to do it.",
        "It's not what we do once in a while that shapes our lives. It's what we do consistently.",
        "Motivation gets you going, but discipline keeps you growing.",
        "Small daily improvements over time lead to stunning results.",
        "The secret of your future is hidden in your daily routine."
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireContext().getSharedPreferences(
            "CONSISTANCY",
            Context.MODE_PRIVATE
        )

        loadHomeUI(view)

        // 🔄 Listen for reset from Settings
        parentFragmentManager.setFragmentResultListener(
            "RESET_DONE",
            viewLifecycleOwner
        ) { _, _ ->
            loadHomeUI(view)
        }
    }

    private fun loadHomeUI(view: View) {
        val tvDay = view.findViewById<TextView>(R.id.tvDay)
        val tvStreak = view.findViewById<TextView>(R.id.tvStreak)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        val cbTask1 = view.findViewById<CheckBox>(R.id.cbHomeTask1)
        val cbTask2 = view.findViewById<CheckBox>(R.id.cbHomeTask2)
        val tvTask1Title = view.findViewById<TextView>(R.id.tvTask1Title)
        val tvTask2Title = view.findViewById<TextView>(R.id.tvTask2Title)
        val btnComplete = view.findViewById<MaterialButton>(R.id.btnCompleteDay)
        val konfettiView = view.findViewById<KonfettiView>(R.id.konfettiView)
        val tvQuote = view.findViewById<TextView>(R.id.tvQuoteText)
        val cardReflection = view.findViewById<MaterialCardView>(R.id.cardReflection)
        val etReflection = view.findViewById<EditText>(R.id.etReflection)

        val currentDay = prefs.getInt("DAY", 1)
        val streak = prefs.getInt("STREAK", 0)

        // Set Daily Quote
        tvQuote.text = "\"${quotes[currentDay % quotes.size]}\""

        tvDay.text = "Day $currentDay / 180"
        tvStreak.text = "🔥 $streak Day Streak"
        progressBar.progress = currentDay

        val tasks = DayTaskProvider.getTasksForDay(currentDay)

        if (tasks.size >= 2) {
            tvTask1Title.text = tasks[0].title
            tvTask2Title.text = tasks[1].title
        }

        cbTask1.setOnCheckedChangeListener(null)
        cbTask2.setOnCheckedChangeListener(null)

        cbTask1.isChecked = prefs.getBoolean("TASK_${currentDay}_1", false)
        cbTask2.isChecked = prefs.getBoolean("TASK_${currentDay}_2", false)

        updateReflectionVisibility(cardReflection, cbTask1.isChecked && cbTask2.isChecked)
        etReflection.setText(prefs.getString("REFLECTION_$currentDay", ""))

        cbTask1.setOnCheckedChangeListener { v, checked ->
            prefs.edit().putBoolean("TASK_${currentDay}_1", checked).apply()
            HapticUtil.light(v)
            updateReflectionVisibility(cardReflection, cbTask1.isChecked && cbTask2.isChecked)
        }

        cbTask2.setOnCheckedChangeListener { v, checked ->
            prefs.edit().putBoolean("TASK_${currentDay}_2", checked).apply()
            HapticUtil.light(v)
            updateReflectionVisibility(cardReflection, cbTask1.isChecked && cbTask2.isChecked)
        }

        // Trigger Review Quiz every 7 days (Day 7, 14, 21...)
        val isReviewDay = currentDay > 0 && currentDay % 7 == 0 && !isReviewDone(currentDay)
        
        if (isReviewDay) {
            btnComplete.text = "TAKE PROGRESS REVIEW"
        } else {
            btnComplete.text = "COMPLETE DAY"
        }

        btnComplete.setOnClickListener {
            if (!cbTask1.isChecked || !cbTask2.isChecked) {
                HapticUtil.warning(it)
                Toast.makeText(requireContext(), "Complete both tasks first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val today = System.currentTimeMillis()
            val lastDone = prefs.getLong("LAST_DONE", 0)

            if (isSameDay(today, lastDone)) {
                Toast.makeText(requireContext(), "Today's tasks already completed", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isReviewDay) {
                showReviewQuizDialog(currentDay) { score ->
                    saveReviewResult(currentDay, score)
                    proceedToDailyQuiz(currentDay, streak, today, etReflection.text.toString(), btnComplete, konfettiView, view)
                }
            } else {
                proceedToDailyQuiz(currentDay, streak, today, etReflection.text.toString(), btnComplete, konfettiView, view)
            }
        }
    }

    private fun proceedToDailyQuiz(day: Int, streak: Int, timestamp: Long, reflection: String, btn: View, konfetti: KonfettiView, root: View) {
        showQuizDialog(day) { score ->
            saveDayCompletion(day, streak, timestamp, reflection, score)
            
            val party = Party(
                speed = 0f, maxSpeed = 30f, damping = 0.9f, spread = 360,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xbbf9b0),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                position = Position.Relative(0.5, 0.3)
            )
            konfetti.start(party)

            HapticUtil.success(btn)
            showMilestoneDialog(day)
            
            root.postDelayed({ if (isAdded) loadHomeUI(root) }, 1000)
        }
    }

    private fun isReviewDone(day: Int): Boolean {
        val reviewIndex = day / 7
        return prefs.getBoolean("REVIEW_DONE_$reviewIndex", false)
    }

    private fun showReviewQuizDialog(day: Int, onComplete: (Int) -> Unit) {
        val reviewIndex = day / 7
        val questions = QuizProvider.getProgressReviewQuiz(reviewIndex)
        showQuizFlow(questions, "Progress Review #$reviewIndex", onComplete)
    }

    private fun showQuizDialog(day: Int, onComplete: (Int) -> Unit) {
        val questions = QuizProvider.getDailyQuiz(day)
        showQuizFlow(questions, "Quick Daily Quiz", onComplete)
    }

    private fun showQuizFlow(questions: List<QuizQuestion>, title: String, onComplete: (Int) -> Unit) {
        var currentQuestionIndex = 0
        var totalScore = 0

        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_quiz, null)
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .create()

        val tvTitle = dialogView.findViewById<TextView>(R.id.tvQuizTitle)
        val tvQuestion = dialogView.findViewById<TextView>(R.id.tvQuizQuestion)
        val rgOptions = dialogView.findViewById<RadioGroup>(R.id.rgOptions)
        val btnSubmit = dialogView.findViewById<MaterialButton>(R.id.btnSubmitQuiz)
        val rbOptions = listOf(
            dialogView.findViewById<RadioButton>(R.id.rbOption1),
            dialogView.findViewById<RadioButton>(R.id.rbOption2),
            dialogView.findViewById<RadioButton>(R.id.rbOption3),
            dialogView.findViewById<RadioButton>(R.id.rbOption4)
        )

        tvTitle.text = title

        fun loadQuestion() {
            val q = questions[currentQuestionIndex]
            tvQuestion.text = q.question
            rgOptions.clearCheck()
            q.options.forEachIndexed { index, s ->
                rbOptions[index].text = s
                rbOptions[index].visibility = View.VISIBLE
            }
            for (i in q.options.size until 4) rbOptions[i].visibility = View.GONE
            btnSubmit.text = if (currentQuestionIndex == questions.size - 1) "SUBMIT" else "NEXT"
        }

        loadQuestion()

        btnSubmit.setOnClickListener {
            val checkedId = rgOptions.checkedRadioButtonId
            if (checkedId == -1) {
                Toast.makeText(requireContext(), "Select an option", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedIndex = rbOptions.indexOf(dialogView.findViewById(checkedId))
            if (selectedIndex == questions[currentQuestionIndex].correctOptionIndex) totalScore++

            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                loadQuestion()
            } else {
                dialog.dismiss()
                onComplete(totalScore)
            }
        }
        dialog.show()
    }

    private fun saveReviewResult(day: Int, score: Int) {
        val reviewIndex = day / 7
        prefs.edit()
            .putBoolean("REVIEW_DONE_$reviewIndex", true)
            .putInt("REVIEW_TOTAL_ATTEMPTED", prefs.getInt("REVIEW_TOTAL_ATTEMPTED", 0) + 1)
            .putInt("REVIEW_TOTAL_SCORE", prefs.getInt("REVIEW_TOTAL_SCORE", 0) + score)
            .apply()
    }

    private fun saveDayCompletion(day: Int, streak: Int, timestamp: Long, reflection: String, quizScore: Int) {
        prefs.edit()
            .putInt("DAY", day + 1)
            .putInt("STREAK", streak + 1)
            .putLong("LAST_DONE", timestamp)
            .putString("REFLECTION_$day", reflection)
            .putInt("QUIZ_SCORE_$day", quizScore)
            .putInt("QUIZ_TOTAL_ATTEMPTED", prefs.getInt("QUIZ_TOTAL_ATTEMPTED", 0) + 1)
            .putInt("QUIZ_TOTAL_SCORE", prefs.getInt("QUIZ_TOTAL_SCORE", 0) + quizScore)
            .apply()
    }

    private fun updateReflectionVisibility(card: View, visible: Boolean) {
        card.visibility = if (visible) View.VISIBLE else View.GONE
    }

    private fun isSameDay(t1: Long, t2: Long): Boolean {
        return t1 / (1000 * 60 * 60 * 24) == t2 / (1000 * 60 * 60 * 24)
    }

    private fun showMilestoneDialog(day: Int) {
        val message = when (day) {
            7 -> "7 days! Foundation built 💪"
            30 -> "30 days! Habit solidified 🚀"
            90 -> "90 days! You are unstoppable 🤖"
            180 -> "180 days! Transformation complete 🏆"
            else -> return
        }
        com.google.android.material.dialog.MaterialAlertDialogBuilder(requireContext())
            .setTitle("🎉 Milestone!")
            .setMessage(message)
            .setPositiveButton("Awesome!", null)
            .show()
    }
}
