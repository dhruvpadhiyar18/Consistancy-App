package com.consistancy.app

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = requireContext()
            .getSharedPreferences("CONSISTANCY", Context.MODE_PRIVATE)

        val tvVersion = view.findViewById<TextView>(R.id.tvVersion)
        val btnReset = view.findViewById<Button>(R.id.btnReset)

        // ---------- APP VERSION ----------
        val versionName = try {
            val pInfo = requireContext()
                .packageManager
                .getPackageInfo(requireContext().packageName, 0)
            pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            "1.0"
        }

        tvVersion.text = "Version: $versionName"

        // ---------- RESET ----------
        btnReset.setOnClickListener {

            prefs.edit().clear().apply()

            Toast.makeText(
                requireContext(),
                "Progress reset successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
