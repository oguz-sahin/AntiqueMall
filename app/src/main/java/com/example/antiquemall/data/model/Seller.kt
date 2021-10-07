package com.example.antiquemall.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Oguz Sahin on 9/10/2021.
 */
@Parcelize
data class Seller(
    var name: String = "",
    var photoUrl: String = "",
    var phone: String = "",
    var city: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0
) : Parcelable
