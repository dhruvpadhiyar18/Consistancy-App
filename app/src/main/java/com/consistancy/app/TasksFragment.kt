package com.consistancy.app

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

        prefs = requireContext().getSharedPreferences(
            "CONSISTANCY",
            Context.MODE_PRIVATE
        )

        loadTasksUI(view)
    }

    override fun onResume() {
        super.onResume()
        // 🔄 IMPORTANT: refresh when coming back from Home
        view?.let { loadTasksUI(it) }
    }

    private fun loadTasksUI(view: View) {

        val currentDay = prefs.getInt("DAY", 1)
        val tasks = DayTaskProvider.getTasksForDay(currentDay)

        // ---------- TASK 1 ----------
        val tvTitle1 = view.findViewById<TextView>(R.id.tvTaskTitle1)
        val tvDesc1 = view.findViewById<TextView>(R.id.tvTaskDesc1)
        val cb1 = view.findViewById<CheckBox>(R.id.cbTask1)
        val btnWhy1 = view.findViewById<Button>(R.id.btnWhy1)
        val btnRes1 = view.findViewById<Button>(R.id.btnResource1)

        tvTitle1.text = tasks[0].title
        tvDesc1.text = tasks[0].whatToDo

        cb1.isChecked =
            TaskPrefs.isTaskDone(requireContext(), currentDay, 1)

        cb1.setOnCheckedChangeListener { _, checked ->
            TaskPrefs.setTaskDone(requireContext(), currentDay, 1, checked)
        }

        btnWhy1.setOnClickListener {
            showWhy(tasks[0].whyThisMatters)
        }

        btnRes1.setOnClickListener {
            openResource(tasks[0].resourceUrl)
        }

        // ---------- TASK 2 ----------
        val tvTitle2 = view.findViewById<TextView>(R.id.tvTaskTitle2)
        val tvDesc2 = view.findViewById<TextView>(R.id.tvTaskDesc2)
        val cb2 = view.findViewById<CheckBox>(R.id.cbTask2)
        val btnWhy2 = view.findViewById<Button>(R.id.btnWhy2)
        val btnRes2 = view.findViewById<Button>(R.id.btnResource2)

        tvTitle2.text = tasks[1].title
        tvDesc2.text = tasks[1].whatToDo

        cb2.isChecked =
            TaskPrefs.isTaskDone(requireContext(), currentDay, 2)

        cb2.setOnCheckedChangeListener { _, checked ->
            TaskPrefs.setTaskDone(requireContext(), currentDay, 2, checked)
        }

        btnWhy2.setOnClickListener {
            showWhy(tasks[1].whyThisMatters)
        }

        btnRes2.setOnClickListener {
            openResource(tasks[1].resourceUrl)
        }
    }

    private fun showWhy(text: String) {
        android.app.AlertDialog.Builder(requireContext())
            .setTitle("Why this matters")
            .setMessage(text)
            .setPositiveButton("Got it", null)
            .show()
    }

    private fun openResource(url: String) {
        val intent = Intent(requireContext(), WebViewActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}
