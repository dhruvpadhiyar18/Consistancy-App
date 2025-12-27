package com.consistancy.app

import android.content.Context

object ProgressManager {

    private const val PREFS = "consistancy_prefs"

    private const val KEY_DAY = "current_day"
    private const val KEY_STREAK = "streak"
    private const val KEY_TASK1 = "task1_done"
    private const val KEY_TASK2 = "task2_done"

    fun getDay(context: Context): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getInt(KEY_DAY, 1)

    fun getStreak(context: Context): Int =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getInt(KEY_STREAK, 0)

    fun isTask1Done(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getBoolean(KEY_TASK1, false)

    fun isTask2Done(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .getBoolean(KEY_TASK2, false)

    fun setTask1(context: Context, done: Boolean) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putBoolean(KEY_TASK1, done).apply()
    }

    fun setTask2(context: Context, done: Boolean) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().putBoolean(KEY_TASK2, done).apply()
    }

    fun completeDay(context: Context) {
        val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

        val day = prefs.getInt(KEY_DAY, 1)
        val streak = prefs.getInt(KEY_STREAK, 0)

        prefs.edit()
            .putInt(KEY_DAY, day + 1)
            .putInt(KEY_STREAK, streak + 1)
            .putBoolean(KEY_TASK1, false)
            .putBoolean(KEY_TASK2, false)
            .apply()
    }

    fun reset(context: Context) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            .edit().clear().apply()
    }
}
