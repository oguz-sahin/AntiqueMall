package com.example.antiquemall.util.manager

import android.os.Bundle
import com.huawei.hms.analytics.HiAnalyticsInstance

/**
 * Created by Oguz Sahin on 9/8/2021.
 */
object AnalyticsManager {

    const val CONTINUE_WITHOUT_SIGN_IN = "CONTINUE_WITHOUT_SIGN_IN"
    const val ADS_CLOSED = "ADS_CLOSED"
    const val ADS_CLICKED = "ADS_CLOSED"
    const val GET_CONTACT_CLICKED = "GET_CONTACT_CLICKED"
    const val CONTACT_PHONE_KEY = "CONTACT_PHONE"
    const val DELETE_PRODUCT_TO_WISHLIST = "DELETE_PRODUCT_TO_WISHLIST"
    const val PRICE_KEY = "PRICE"
    const val PRODUCT_ID_KEY = "PRODUCT_ID"
    const val PRODUCT_NAME_KEY = "PRODUCT_NAME"
    const val CITY_KEY = "\$City"


    var analyticsInstance: HiAnalyticsInstance? = null

    fun sendEvent(eventName: String, bundleBlock: (Bundle.() -> Unit)? = null) {
        val bundle = bundleBlock?.let { Bundle().apply(it) }
        analyticsInstance?.onEvent(eventName, bundle)
    }

}