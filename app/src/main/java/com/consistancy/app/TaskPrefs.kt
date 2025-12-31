package com.consistancy.app

import android.content.Context

object TaskPrefs {

    private fun prefs(context: Context) =
        context.getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)

    fun isTaskDone(context: Context, day: Int, taskIndex: Int): Boolean {
        return prefs(context).getBoolean("TASK_${day}_$taskIndex", false)
    }

    fun setTaskDone(context: Context, day: Int, taskIndex: Int, done: Boolean) {
        prefs(context).edit()
            .putBoolean("TASK_${day}_$taskIndex", done)
            .apply()
    }
}
