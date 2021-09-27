package com.example.antiquemall.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Oguz Sahin on 9/24/2021.
 */

@BindingAdapter("loadUrl")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(ColorDrawable(Color.GRAY))
        .into(this)

}
