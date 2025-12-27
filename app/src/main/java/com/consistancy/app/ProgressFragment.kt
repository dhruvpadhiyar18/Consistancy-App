package com.consistancy.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProgressFragment : Fragment() {

    private val TOTAL_DAYS = 180

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_progress, container, false)

        val prefs = requireContext()
            .getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)

        val currentDay = prefs.getInt("DAY", 1)
        val streak = prefs.getInt("STREAK", 0)

        val tvDay = view.findViewById<TextView>(R.id.tvDayProgress)
        val tvStreak = view.findViewById<TextView>(R.id.tvStreakProgress)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBarOverall)
        val tvPercent = view.findViewById<TextView>(R.id.tvProgressPercent)

        val m7 = view.findViewById<TextView>(R.id.m7)
        val m30 = view.findViewById<TextView>(R.id.m30)
        val m90 = view.findViewById<TextView>(R.id.m90)
        val m180 = view.findViewById<TextView>(R.id.m180)

        // Set values
        tvDay.text = "Day $currentDay / $TOTAL_DAYS"
        tvStreak.text = "🔥 Streak: $streak days"

        progressBar.progress = currentDay
        val percent = (currentDay * 100) / TOTAL_DAYS
        tvPercent.text = "$percent% completed"

        // Milestones
        if (currentDay >= 7) m7.text = "✅ Day 7 – Foundation Discipline"
        if (currentDay >= 30) m30.text = "✅ Day 30 – Core Python + DSA"
        if (currentDay >= 90) m90.text = "✅ Day 90 – AI/ML Track Started"
        if (currentDay >= 180) m180.text = "🏆 Day 180 – Career Ready"

        return view
    }
}
