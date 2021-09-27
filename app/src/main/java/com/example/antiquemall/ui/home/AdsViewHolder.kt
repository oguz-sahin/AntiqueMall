package com.example.antiquemall.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.example.antiquemall.databinding.ItemAdsBinding
import com.example.antiquemall.util.ext.loadAds

/**
 * Created by Oguz Sahin on 9/24/2021.
 */
class AdsViewHolder(private val binding: ItemAdsBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind() {
        binding.hwBannerView.loadAds()
    }
}