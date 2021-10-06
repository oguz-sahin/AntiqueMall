package com.example.antiquemall.util

import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Oguz Sahin on 9/8/2021.
 */


fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    requireActivity().showToast(message, duration)
}
