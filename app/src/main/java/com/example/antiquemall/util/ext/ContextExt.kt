package com.example.antiquemall.util

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat

/**
 * Created by Oguz Sahin on 9/8/2021.
 */


fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.hasPermissions(vararg permissions: String) = permissions.all { permission ->
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Context.makePhoneCall(phone: String?) {
    try {
        Intent(
            Intent.ACTION_CALL,
            Uri.parse("tel:$phone")
        ).run {
            startActivity(this)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}