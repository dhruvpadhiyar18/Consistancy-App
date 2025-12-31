package com.consistancy.app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private lateinit var prefs: android.content.SharedPreferences
    private var selectedDay: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireContext().getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)
        val currentDay = prefs.getInt("DAY", 1)
        selectedDay = currentDay

        loadTasksUI(view, selectedDay)

        // Setup Day Picker Button
        val btnDayPicker = view.findViewById<MaterialButton>(R.id.btnDayPicker)
        btnDayPicker.setOnClickListener {
            showDayPickerDialog(view, currentDay)
        }
    }

    private fun showDayPickerDialog(rootView: View, currentDay: Int) {
        val days = Array(currentDay) { "Day ${it + 1}" }
        
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Select Journey Day")
            .setItems(days) { _, which ->
                selectedDay = which + 1
                loadTasksUI(rootView, selectedDay)
            }
            .show()
    }

    private fun loadTasksUI(view: View, day: Int) {
        val currentDay = prefs.getInt("DAY", 1)
        val tasks = DayTaskProvider.getTasksForDay(day)

        view.findViewById<TextView>(R.id.tvTasksTitle).text = if (day == currentDay) "Today's Mission" else "Day $day Mission"
        
        val tvTitle1 = view.findViewById<TextView>(R.id.tvTaskTitle1)
        val tvDesc1 = view.findViewById<TextView>(R.id.tvTaskDesc1)
        val cb1 = view.findViewById<CheckBox>(R.id.cbHomeTask1)
        val btnWhy1 = view.findViewById<MaterialButton>(R.id.btnWhy1)
        val btnRes1 = view.findViewById<MaterialButton>(R.id.btnResource1)

        val tvTitle2 = view.findViewById<TextView>(R.id.tvTaskTitle2)
        val tvDesc2 = view.findViewById<TextView>(R.id.tvTaskDesc2)
        val cb2 = view.findViewById<CheckBox>(R.id.cbHomeTask2)
        val btnWhy2 = view.findViewById<MaterialButton>(R.id.btnWhy2)
        val btnRes2 = view.findViewById<MaterialButton>(R.id.btnResource2)

        val cardReflection = view.findViewById<MaterialCardView>(R.id.cardPastReflection)
        val tvReflection = view.findViewById<TextView>(R.id.tvPastReflection)

        // Clear listeners
        cb1.setOnCheckedChangeListener(null)
        cb2.setOnCheckedChangeListener(null)

        if (tasks.isNotEmpty()) {
            tvTitle1.text = tasks[0].title
            tvDesc1.text = tasks[0].whatToDo
            cb1.isChecked = prefs.getBoolean("TASK_${day}_1", false)
            
            if (day == currentDay) {
                cb1.isEnabled = true
                cb1.setOnCheckedChangeListener { v, checked ->
                    prefs.edit().putBoolean("TASK_${day}_1", checked).apply()
                    HapticUtil.light(v)
                }
            } else {
                cb1.isEnabled = false
            }

            btnWhy1.setOnClickListener { showWhy(tasks[0].whyThisMatters) }
            btnRes1.setOnClickListener { openResource(tasks[0].resourceUrl) }
        }

        if (tasks.size >= 2) {
            tvTitle2.text = tasks[1].title
            tvDesc2.text = tasks[1].whatToDo
            cb2.isChecked = prefs.getBoolean("TASK_${day}_2", false)

            if (day == currentDay) {
                cb2.isEnabled = true
                cb2.setOnCheckedChangeListener { v, checked ->
                    prefs.edit().putBoolean("TASK_${day}_2", checked).apply()
                    HapticUtil.light(v)
                }
            } else {
                cb2.isEnabled = false
            }

            btnWhy2.setOnClickListener { showWhy(tasks[1].whyThisMatters) }
            btnRes2.setOnClickListener { openResource(tasks[1].resourceUrl) }
        }

        // Reflection display
        val reflection = prefs.getString("REFLECTION_$day", "")
        if (!reflection.isNullOrBlank()) {
            cardReflection.visibility = View.VISIBLE
            tvReflection.text = reflection
        } else {
            cardReflection.visibility = View.GONE
        }
    }

    private fun showWhy(text: String) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Why this matters")
            .setMessage(text)
            .setPositiveButton("Got it", null)
            .show()
    }

    private fun openResource(url: String) {
        try {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            intent.putExtra("URL", url)
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Unable to open resource", Toast.LENGTH_SHORT).show()
        }
    }
}
