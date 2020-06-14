package com.qndzia.tapformelody.preferences

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreferenceCompat
import com.qndzia.tapformelody.R
import kotlinx.android.synthetic.main.fragment_play_and_record.*

class MySettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val switchKeyLabels: SwitchPreferenceCompat? = findPreference("key_labels")

        switchKeyLabels?.setOnPreferenceChangeListener { _, newValue ->
            if (newValue == true) {

//                this.findNavController().navigate(
//                    MySettingsFragmentDirections.actionMySettingsFragmentToPlayAndRecord(false)
//                )


            } else {

//                this.findNavController().navigate(
//                    MySettingsFragmentDirections.actionMySettingsFragmentToPlayAndRecord(true)
//                )


            }
            true

        }
    }
}