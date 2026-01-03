package com.consistancy.app

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import java.io.File
import java.io.FileOutputStream

class ProgressFragment : Fragment(R.layout.fragment_progress) {

    private lateinit var prefs: android.content.SharedPreferences
    private val totalDays = 180

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = requireContext().getSharedPreferences(
            "CONSISTANCY",
            Context.MODE_PRIVATE
        )

        val currentDay = prefs.getInt("DAY", 1)
        val streak = prefs.getInt("STREAK", 0)

        val tvDay = view.findViewById<TextView>(R.id.tvDayProgress)
        val tvStreak = view.findViewById<TextView>(R.id.tvStreakProgress)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBarProgress)
        val tvPercent = view.findViewById<TextView>(R.id.tvPercent)
        val btnShare = view.findViewById<MaterialButton>(R.id.btnShare)
        val shareCard = view.findViewById<LinearLayout>(R.id.shareCardContainer)

        val trophy1 = view.findViewById<ImageView>(R.id.trophy1)
        val trophy2 = view.findViewById<ImageView>(R.id.trophy2)
        val trophy3 = view.findViewById<ImageView>(R.id.trophy3)
        val trophy4 = view.findViewById<ImageView>(R.id.trophy4)

        tvDay.text = "Day $currentDay / $totalDays"
        tvStreak.text = "🔥 $streak Days"

        progressBar.max = totalDays
        progressBar.progress = currentDay

        val percent = (currentDay * 100) / totalDays
        tvPercent.text = "$percent%"

        // NEW: Load Analytics
        loadAnalytics(view)

        // Unlock Trophies
        if (currentDay >= 7) trophy1.alpha = 1.0f
        if (currentDay >= 30) trophy2.alpha = 1.0f
        if (currentDay >= 90) trophy3.alpha = 1.0f
        if (currentDay >= 180) trophy4.alpha = 1.0f

        btnShare.setOnClickListener {
            shareProgress(shareCard)
        }
    }

    private fun loadAnalytics(view: View) {
        val tvStats = view.findViewById<TextView>(R.id.tvStatsLabel) ?: return // Safeguard
        
        val totalAttempted = prefs.getInt("QUIZ_TOTAL_ATTEMPTED", 0)
        val totalScore = prefs.getInt("QUIZ_TOTAL_SCORE", 0)
        
        // Total possible score: 2 questions per day
        val totalPossible = totalAttempted * 2
        val accuracy = if (totalPossible > 0) (totalScore * 100) / totalPossible else 0
        
        val weekendAttempted = prefs.getInt("WEEKEND_TEST_ATTEMPTED", 0)
        val weekendTotalScore = prefs.getInt("WEEKEND_TEST_TOTAL_SCORE", 0)
        
        // Update stats UI (IDs added in XML)
        view.findViewById<TextView>(R.id.tvQuizAccuracy)?.text = "$accuracy%"
        view.findViewById<TextView>(R.id.tvQuizzesDone)?.text = totalAttempted.toString()
        view.findViewById<TextView>(R.id.tvWeekendScore)?.text = weekendTotalScore.toString()
    }

    private fun shareProgress(view: View) {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        view.draw(canvas)

        try {
            val cachePath = File(requireContext().cacheDir, "images")
            cachePath.mkdirs()
            val stream = FileOutputStream("$cachePath/image.png")
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()

            val imagePath = File(requireContext().cacheDir, "images")
            val newFile = File(imagePath, "image.png")
            val contentUri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.provider", newFile)

            if (contentUri != null) {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                shareIntent.setDataAndType(contentUri, requireContext().contentResolver.getType(contentUri))
                shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri)
                shareIntent.putExtra(Intent.EXTRA_TEXT, "I am on Day ${prefs.getInt("DAY", 1)} of my 180-day consistency journey! 🔥")
                startActivity(Intent.createChooser(shareIntent, "Share Progress"))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
