package com.consistancy.app

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var prefs: android.content.SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs =
            requireContext().getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)

        loadHomeUI(view)

        // 🔄 Listen for reset
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
        val btnComplete = view.findViewById<Button>(R.id.btnCompleteDay)

        val currentDay = prefs.getInt("DAY", 1)
        val streak = prefs.getInt("STREAK", 0)

        tvDay.text = "Day $currentDay / 180"
        tvStreak.text = "🔥 Streak: $streak"
        progressBar.progress = currentDay

        val tasks = DayTaskProvider.getTasksForDay(currentDay)

        cbTask1.text = tasks[0].title
        cbTask2.text = tasks[1].title

        cbTask1.isChecked = prefs.getBoolean("TASK_${currentDay}_1", false)
        cbTask2.isChecked = prefs.getBoolean("TASK_${currentDay}_2", false)

        cbTask1.setOnCheckedChangeListener { _, checked ->
            prefs.edit().putBoolean("TASK_${currentDay}_1", checked).apply()
        }

        cbTask2.setOnCheckedChangeListener { _, checked ->
            prefs.edit().putBoolean("TASK_${currentDay}_2", checked).apply()
        }

        btnComplete.setOnClickListener {

            if (!cbTask1.isChecked || !cbTask2.isChecked) {
                Toast.makeText(
                    requireContext(),
                    "Please complete both tasks first",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val today = System.currentTimeMillis()
            val lastDone = prefs.getLong("LAST_DONE", 0)

            if (isSameDay(today, lastDone)) {
                Toast.makeText(
                    requireContext(),
                    "Today's tasks already completed",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            prefs.edit()
                .putInt("DAY", currentDay + 1)
                .putInt("STREAK", streak + 1)
                .putLong("LAST_DONE", today)
                .apply()

            Toast.makeText(
                requireContext(),
                "Day $currentDay completed. Come back tomorrow!",
                Toast.LENGTH_LONG
            ).show()

            loadHomeUI(view)
        }
    }

    private fun isSameDay(t1: Long, t2: Long): Boolean {
        return t1 / (1000 * 60 * 60 * 24) ==
                t2 / (1000 * 60 * 60 * 24)
    }

    private fun haptic(view: View) {
        view.performHapticFeedback(android.view.HapticFeedbackConstants.KEYBOARD_TAP)
    }


    private fun showMilestoneDialog(day: Int) {
        val message = when (day) {
            7 -> "You completed 7 days!\nFoundation discipline unlocked 💪"
            30 -> "30 days done!\nCore consistency built 🚀"
            90 -> "90 days!\nAI/ML journey unlocked 🤖"
            180 -> "180 days!\nYou are career-ready 🏆"
            else -> return
        }

        android.app.AlertDialog.Builder(requireContext())
            .setTitle("🎉 Milestone Achieved")
            .setMessage(message)
            .setPositiveButton("Awesome!") { _, _ -> }
            .show()
    }



    private fun animateCheck(view: View) {
        view.animate()
            .scaleX(1.15f)
            .scaleY(1.15f)
            .setDuration(120)
            .withEndAction {
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(120)
                    .start()
            }
            .start()
    }

}
