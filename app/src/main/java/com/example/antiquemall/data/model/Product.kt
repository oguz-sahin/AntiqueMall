package com.example.antiquemall.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Oguz Sahin on 9/10/2021.
 */
@Parcelize
data class Product(
    val id: Int,
    var name: String = "",
    var color: String = "",
    var material: String = "",
    var status: String = "",
    var price: Double = 0.0,
    var photoUrls: List<String> = listOf(),
    var dimension: String,
    var seller: Seller = Seller(),
    var isFavorite: Boolean = false
) : Parcelable
