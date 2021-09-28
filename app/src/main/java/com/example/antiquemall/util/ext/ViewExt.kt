package com.example.antiquemall.util

import android.view.View

/**
 * Created by Oguz Sahin on 9/7/2021.
 */

fun View.visible() {
    visibility = View.VISIBLE
}


fun View.gone() {
    visibility = View.GONE
}

fun View.setVisibility(isVisible: Boolean) {
    if (isVisible) visible() else gone()
}