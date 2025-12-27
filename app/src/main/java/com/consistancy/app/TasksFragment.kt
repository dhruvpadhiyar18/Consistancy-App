package com.consistancy.app

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment

class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private lateinit var prefs: android.content.SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs =
            requireContext().getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)

        loadTasks(view)

        // 🔄 Listen for reset
        parentFragmentManager.setFragmentResultListener(
            "RESET_DONE",
            viewLifecycleOwner
        ) { _, _ ->
            loadTasks(view)
        }
    }


    private fun loadTasks(view: View) {

        val currentDay = prefs.getInt("DAY", 1)
        val tasks = DayTaskProvider.getTasksForDay(currentDay)

        val t1 = tasks[0]
        val t2 = tasks[1]

        // ---------- TASK 1 ----------
        view.findViewById<TextView>(R.id.tvTaskTitle1).text = t1.title
        view.findViewById<TextView>(R.id.tvTaskDesc1).text = t1.whatToDo

        val cb1 = view.findViewById<CheckBox>(R.id.cbTask1)
        cb1.isChecked = prefs.getBoolean("TASK_${currentDay}_1", false)

        cb1.setOnCheckedChangeListener { _, checked ->
            prefs.edit().putBoolean("TASK_${currentDay}_1", checked).apply()
        }

        view.findViewById<Button>(R.id.btnWhy1).setOnClickListener {
            showWhyDialog(t1.title, t1.whyThisMatters)
        }

        view.findViewById<Button>(R.id.btnResource1).setOnClickListener {
            openWeb(t1.resourceUrl)
        }

        // ---------- TASK 2 ----------
        view.findViewById<TextView>(R.id.tvTaskTitle2).text = t2.title
        view.findViewById<TextView>(R.id.tvTaskDesc2).text = t2.whatToDo

        val cb2 = view.findViewById<CheckBox>(R.id.cbTask2)
        cb2.isChecked = prefs.getBoolean("TASK_${currentDay}_2", false)

        cb2.setOnCheckedChangeListener { _, checked ->
            prefs.edit().putBoolean("TASK_${currentDay}_2", checked).apply()
        }

        view.findViewById<Button>(R.id.btnWhy2).setOnClickListener {
            showWhyDialog(t2.title, t2.whyThisMatters)
        }

        view.findViewById<Button>(R.id.btnResource2).setOnClickListener {
            openWeb(t2.resourceUrl)
        }
    }

    // ✅ WHY THIS MATTERS DIALOG
    private fun showWhyDialog(title: String, message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle("💡 Why this matters")
            .setMessage(message)
            .setPositiveButton("Got it") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

    private fun openWeb(url: String) {
        val intent = Intent(requireContext(), WebViewActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }

    private fun haptic(view: View) {
        view.performHapticFeedback(android.view.HapticFeedbackConstants.KEYBOARD_TAP)
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
