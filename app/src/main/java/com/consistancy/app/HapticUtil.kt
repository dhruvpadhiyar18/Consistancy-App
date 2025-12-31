package com.consistancy.app

import android.view.HapticFeedbackConstants
import android.view.View

object HapticUtil {

    // Light feedback → checkbox, small taps
    fun light(view: View) {
        view.performHapticFeedback(
            HapticFeedbackConstants.KEYBOARD_TAP
        )
    }

    // Success feedback → day completed
    fun success(view: View) {
        view.performHapticFeedback(
            HapticFeedbackConstants.CONFIRM
        )
    }

    // Warning feedback → reset, incomplete tasks
    fun warning(view: View) {
        view.performHapticFeedback(
            HapticFeedbackConstants.LONG_PRESS
        )
    }
}
