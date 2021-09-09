package com.example.antiquemall.util

import android.content.Context
import android.widget.Toast

/**
 * Created by Oguz Sahin on 9/8/2021.
 */


fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}