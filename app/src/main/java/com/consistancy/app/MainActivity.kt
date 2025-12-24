package com.consistancy.app

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private val TOTAL_DAYS = 180

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)

        val tvDay = findViewById<TextView>(R.id.tvDay)
        val tvCountdown = findViewById<TextView>(R.id.tvCountdown)
        val tvStreak = findViewById<TextView>(R.id.tvStreak)
        val tvMotivation = findViewById<TextView>(R.id.tvMotivation)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val btnComplete = findViewById<Button>(R.id.btnComplete)
        val taskContainer = findViewById<LinearLayout>(R.id.taskContainer)

        val milestone7 = findViewById<TextView>(R.id.milestone7)
        val milestone30 = findViewById<TextView>(R.id.milestone30)
        val milestone90 = findViewById<TextView>(R.id.milestone90)
        val milestone180 = findViewById<TextView>(R.id.milestone180)

        var currentDay = prefs.getInt("DAY", 1)
        var streak = prefs.getInt("STREAK", 0)

        progressBar.max = TOTAL_DAYS
        progressBar.progress = currentDay

        tvDay.text = "Day $currentDay of $TOTAL_DAYS"
        tvCountdown.text = "${TOTAL_DAYS - currentDay} days remaining"
        tvStreak.text = "🔥 Streak: $streak days"

        updateMilestones(currentDay, milestone7, milestone30, milestone90, milestone180)

        var taskCheckBoxes = loadTasks(currentDay, taskContainer)

        btnComplete.setOnClickListener {

            val today = LocalDate.now().toString()
            val lastDone = prefs.getString("LAST_DATE", "")

            if (today == lastDone) {
                Toast.makeText(this, "Already completed today", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (taskCheckBoxes.all { it.isChecked }) {

                if (currentDay < TOTAL_DAYS) currentDay++
                streak++

                prefs.edit()
                    .putInt("DAY", currentDay)
                    .putInt("STREAK", streak)
                    .putString("LAST_DATE", today)
                    .apply()

                tvDay.text = "Day $currentDay of $TOTAL_DAYS"
                tvCountdown.text = "${TOTAL_DAYS - currentDay} days remaining"
                tvStreak.text = "🔥 Streak: $streak days"
                progressBar.progress = currentDay

                tvMotivation.text = "Good job! Day ${currentDay - 1} completed."

                updateMilestones(currentDay, milestone7, milestone30, milestone90, milestone180)

                taskCheckBoxes = loadTasks(currentDay, taskContainer)

            } else {
                Toast.makeText(this, "Complete both tasks first", Toast.LENGTH_SHORT).show()
            }
        }

        scheduleNotification()
    }

    // ---------- TASK UI + RESOURCE ----------
    private fun loadTasks(day: Int, container: LinearLayout): List<CheckBox> {

        container.removeAllViews()
        val tasks = DayTaskProvider.getTasksForDay(day)
        val checkBoxes = mutableListOf<CheckBox>()

        for (task in tasks) {

            val card = LinearLayout(this)
            card.orientation = LinearLayout.VERTICAL
            card.setPadding(24, 16, 24, 16)
            card.setBackgroundResource(android.R.drawable.dialog_holo_light_frame)

            val cb = CheckBox(this)
            cb.text = "${task.title}\n${task.description}"
            cb.textSize = 15f

            val btn = Button(this)
            btn.text = "Open Resource"
            btn.textSize = 14f

            btn.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, android.net.Uri.parse(task.resourceUrl)))
            }

            card.addView(cb)
            card.addView(btn)
            container.addView(card)

            checkBoxes.add(cb)
        }
        return checkBoxes
    }

    // ---------- MILESTONES ----------
    private fun updateMilestones(d: Int, m7: TextView, m30: TextView, m90: TextView, m180: TextView) {
        if (d >= 7) m7.text = "✅ Day 7 – Foundation Discipline"
        if (d >= 30) m30.text = "✅ Day 30 – Core Python + DSA"
        if (d >= 90) m90.text = "✅ Day 90 – AI/ML Track Started"
        if (d >= 180) m180.text = "🏆 Day 180 – Career Ready"
    }

    // ---------- DAILY NOTIFICATION ----------
    private fun scheduleNotification() {
        val intent = Intent(this, NotificationReceiver::class.java)
        val pending = PendingIntent.getBroadcast(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarm = getSystemService(ALARM_SERVICE) as AlarmManager
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 8)
        cal.set(Calendar.MINUTE, 0)

        alarm.setRepeating(
            AlarmManager.RTC_WAKEUP,
            cal.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pending
        )
    }
}
