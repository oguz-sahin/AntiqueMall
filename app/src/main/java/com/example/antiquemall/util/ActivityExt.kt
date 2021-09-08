package com.example.antiquemall.util

import android.app.Activity
import android.os.Build
import android.view.WindowInsets
import android.view.WindowManager

/**
 * Created by Oguz Sahin on 9/8/2021.
 */
fun Activity.goneStatusBar() {
    @Suppress("DEPRECATION")
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.insetsController?.hide(WindowInsets.Type.statusBars())
    } else {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}