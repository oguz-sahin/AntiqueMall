package com.example.antiquemall.ui.common

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.antiquemall.util.setVisibility

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

@BindingAdapter("isVisible")
fun View.setVisibility(isVisible: Boolean) {
    setVisibility(isVisible)
}
