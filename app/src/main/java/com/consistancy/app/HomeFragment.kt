package com.consistancy.app

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
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

        // Show reflection if tasks are done
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

            // Save reflection
            val reflection = etReflection.text.toString()
            prefs.edit().putString("REFLECTION_$currentDay", reflection).apply()

            // Celebrate
            val party = Party(
                speed = 0f, maxSpeed = 30f, damping = 0.9f, spread = 360,
                colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xbbf9b0),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                position = Position.Relative(0.5, 0.3)
            )
            konfettiView.start(party)

            prefs.edit()
                .putInt("DAY", currentDay + 1)
                .putInt("STREAK", streak + 1)
                .putLong("LAST_DONE", today)
                .apply()

            HapticUtil.success(it)
            showMilestoneDialog(currentDay)
            
            // Update widget (impl later)
            updateWidget()

            view.postDelayed({ if (isAdded) loadHomeUI(view) }, 1000)
        }
    }

    private fun updateReflectionVisibility(card: View, visible: Boolean) {
        card.visibility = if (visible) View.VISIBLE else View.GONE
    }

    private fun updateWidget() {
        // We will implement AppWidgetProvider next
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
