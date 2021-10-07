package com.example.antiquemall.ui.home.productdetail

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.antiquemall.R

/**
 * Created by Oguz Sahin on 10/4/2021.
 */
enum class ProductDetailTabTypes(
    val positionIndex: Int,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    PRODUCT_INFO(0, R.string.info, R.drawable.ic_info),
    SELLER_LOCATION(1, R.string.location, R.drawable.ic_map)
}