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

package com.flamingo.device.touch

import android.content.Context
import android.os.UserHandle
import android.provider.Settings
import android.util.Log

private const val TAG = "TouchScreenGestureUtils"

fun getResName(name: String): String {
    val gestureName = name.toLowerCase().replace("\\s+".toRegex(), "_")
    return "touchscreen_gesture_${gestureName}_title"
}

fun getSavedAction(context: Context, key: String, def: GestureAction = GestureAction.NONE): GestureAction {
    val actionString = Settings.System.getStringForUser(
        context.contentResolver,
        key,
        UserHandle.USER_CURRENT
    )?.takeIf { it.isNotBlank() } ?: return def
    return try {
        GestureAction.valueOf(actionString)
    } catch(_: IllegalArgumentException) {
        Log.e(TAG, "Unknown gesture action $actionString")
        def
    }
}
