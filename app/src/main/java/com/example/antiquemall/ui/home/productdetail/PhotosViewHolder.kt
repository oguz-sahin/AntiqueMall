package com.example.antiquemall.ui.home.productdetail

import androidx.recyclerview.widget.RecyclerView
import com.example.antiquemall.databinding.ItemPhotoBinding

/**
 * Created by Oguz Sahin on 9/28/2021.
 */
class PhotosViewHolder(private val binding: ItemPhotoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(photoUrl: String) {
        with(binding) {
            imageUrl = photoUrl
            executePendingBindings()
        }
    }
}