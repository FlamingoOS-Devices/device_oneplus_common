/*
 * Copyright (C) 2021 The LineageOS Project
 * Copyright (C) 2022 FlamingoOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flamingo.device.alertslider

import android.os.Bundle

import androidx.fragment.app.commit
import androidx.preference.ListPreference.SimpleSummaryProvider
import androidx.preference.PreferenceFragmentCompat

import com.android.internal.os.AlertSlider.Mode
import com.android.internal.os.AlertSlider.Position
import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity
import com.flamingo.support.preference.SystemSettingListPreference

private val Positions = listOf(
    AlertSliderPosition.Top,
    AlertSliderPosition.Middle,
    AlertSliderPosition.Bottom
)

class SettingsActivity : CollapsingToolbarBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    com.android.settingslib.collapsingtoolbar.R.id.content_frame,
                    SettingsFragment(),
                    null
                )
            }
        }
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.fragment_settings, rootKey)
            val modeEntries = arrayOf(
                resources.getString(R.string.mode_normal),
                resources.getString(R.string.mode_vibrate),
                resources.getString(R.string.mode_priority),
                resources.getString(R.string.mode_silent),
                resources.getString(R.string.mode_dnd)
            )
            val modeEntryValues = Mode.values().map { it.toString() }.toTypedArray()
            Positions.forEachIndexed { index, position ->
                preferenceScreen.addPreference(
                    SystemSettingListPreference(requireContext()).apply {
                        key = position.modeKey
                        title = resources.getString(position.title)
                        entries = modeEntries
                        entryValues = modeEntryValues
                        setDefaultValue(position.defaultMode.toString())
                        order = index
                        dialogTitle = title
                        summaryProvider = SimpleSummaryProvider.getInstance()
                    }
                )
            }
        }
    }
}
