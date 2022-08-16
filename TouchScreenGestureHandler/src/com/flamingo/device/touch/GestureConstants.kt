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

enum class GestureAction {
    NONE,
    FLASHLIGHT,
    CAMERA,
    BROWSER,
    DIALER,
    EMAIL,
    MESSAGES,
    PLAY_PAUSE_MUSIC,
    PREVIOUS_TRACK,
    NEXT_TRACK,
    VOLUME_DOWN,
    VOLUME_UP,
    WAKEUP,
    AMBIENT_DISPLAY
}

enum class GestureDirection (val scanCode: Int){
    LETTER_W(246),
    LETTER_M(247),
    LETTER_S(248),
    LETTER_O(250),
    TWO_FINGER_SWIPE_DOWN(251),
    DOWN_ARROW(252),
    LEFT_ARROW(253),
    RIGHT_ARROW(254),
    SINGLE_TAP(255), 
}

val ScanCodes = GestureDirection.values().map { it.scanCode.toInt() }.toIntArray()

val defaultGestureValues = mapOf(
    GestureDirection.SINGLE_TAP.scanCode to GestureAction.AMBIENT_DISPLAY,
    GestureDirection.TWO_FINGER_SWIPE_DOWN.scanCode to GestureAction.PLAY_PAUSE_MUSIC,
    GestureDirection.DOWN_ARROW.scanCode to GestureAction.FLASHLIGHT,
    GestureDirection.LEFT_ARROW.scanCode to GestureAction.PREVIOUS_TRACK,
    GestureDirection.RIGHT_ARROW.scanCode to GestureAction.NEXT_TRACK,
)
