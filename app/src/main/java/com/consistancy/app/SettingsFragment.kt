package com.consistancy.app

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.materialswitch.MaterialSwitch

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val prefs = requireContext().getSharedPreferences(
            "CONSISTANCY",
            Context.MODE_PRIVATE
        )

        val btnReset = view.findViewById<MaterialButton>(R.id.btnReset)
        val tvVersion = view.findViewById<TextView>(R.id.tvVersion)
        val switchNotification = view.findViewById<MaterialSwitch>(R.id.switchNotification)
        
        val btnPrivacy = view.findViewById<MaterialButton>(R.id.btnPrivacy)
        val btnTerms = view.findViewById<MaterialButton>(R.id.btnTerms)
        val btnContact = view.findViewById<MaterialButton>(R.id.btnContact)

        // Version display
        tvVersion.text = "Version 1.0.0"

        // Notification toggle
        switchNotification.isChecked =
            prefs.getBoolean("NOTIFICATION_ENABLED", true)

        switchNotification.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit()
                .putBoolean("NOTIFICATION_ENABLED", isChecked)
                .apply()

            val status = if (isChecked) "enabled" else "disabled"
            Toast.makeText(requireContext(), "Notifications $status", Toast.LENGTH_SHORT).show()
        }

        // Privacy Policy & Terms (Using your GitHub Pages links)
        btnPrivacy.setOnClickListener {
            openUrl("https://dhruvpadhiyar18.github.io/Consistancy-App/privacy-policy.html")
        }

        btnTerms.setOnClickListener {
            openUrl("https://dhruvpadhiyar18.github.io/Consistancy-App/terms-and-conditions.html")
        }

        // Contact Developer (Using your real Gmail)
        btnContact.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:dhruvgtech@gmail.com")
                putExtra(Intent.EXTRA_SUBJECT, "Support: Consistancy App")
            }
            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "No email app found", Toast.LENGTH_SHORT).show()
            }
        }

        // Reset progress
        btnReset.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Reset All Progress?")
                .setMessage("This will permanently delete your 180-day journey, streaks, and reflections. This action cannot be undone.")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Reset Everything") { _, _ ->
                    HapticUtil.warning(it)
                    prefs.edit().clear().apply()

                    parentFragmentManager.setFragmentResult(
                        "RESET_DONE",
                        Bundle()
                    )

                    Toast.makeText(
                        requireContext(),
                        "Your journey has been reset.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                .show()
        }
    }

    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Cannot open link", Toast.LENGTH_SHORT).show()
        }
    }
}
