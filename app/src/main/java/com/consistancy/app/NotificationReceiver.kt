package com.consistancy.app

import android.app.*
import android.content.*
import androidx.core.app.NotificationCompat

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val prefs = context.getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)
        val day = prefs.getInt("DAY", 1)

        val task1Done = prefs.getBoolean("TASK_${day}_1", false)
        val task2Done = prefs.getBoolean("TASK_${day}_2", false)

        // ❌ If both tasks completed → do nothing
        if (task1Done && task2Done) return

        val channelId = "daily_reminder"

        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= 26) {
            val channel = NotificationChannel(
                channelId,
                "Daily Reminder",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_popup_reminder)
            .setContentTitle("Consistency Reminder 🔥")
            .setContentText("Complete today’s tasks to keep your streak!")
            .setAutoCancel(true)
            .build()

        manager.notify(1001, notification)
    }
}
