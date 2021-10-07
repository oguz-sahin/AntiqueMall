package com.example.antiquemall.ui.home.productdetail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.antiquemall.databinding.ItemPhotoBinding

/**
 * Created by Oguz Sahin on 9/28/2021.
 */
class PhotosAdapter : RecyclerView.Adapter<PhotosViewHolder>() {

    var photos = listOf<String>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size
}