/*
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

import android.provider.Settings.System.ALERTSLIDER_MODE_POSITION_BOTTOM
import android.provider.Settings.System.ALERTSLIDER_MODE_POSITION_MIDDLE
import android.provider.Settings.System.ALERTSLIDER_MODE_POSITION_TOP

import androidx.annotation.StringRes

import com.android.internal.os.AlertSlider.Mode
import com.android.internal.os.AlertSlider.Position

sealed class AlertSliderPosition(
    @StringRes val title: Int,
    val modeKey: String,
    val defaultMode: Mode,
    val position: Position
) {
    object Bottom : AlertSliderPosition(
        R.string.alert_slider_bottom_title,
        ALERTSLIDER_MODE_POSITION_BOTTOM,
        Mode.NORMAL,
        Position.BOTTOM
    )
    object Middle : AlertSliderPosition(
        R.string.alert_slider_middle_title,
        ALERTSLIDER_MODE_POSITION_MIDDLE,
        Mode.VIBRATE,
        Position.MIDDLE
    )
    object Top : AlertSliderPosition(
        R.string.alert_slider_top_title,
        ALERTSLIDER_MODE_POSITION_TOP,
        Mode.SILENT,
        Position.TOP
    )
}