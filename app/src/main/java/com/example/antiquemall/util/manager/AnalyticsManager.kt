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
    const val VIEWED_PRODUCT = "VIEWED_PRODUCT"
    const val PRODUCT_KEY = "PRODUCT"
    const val GET_CONTACT_CLICKED = "GET_CONTACT_CLICKED"
    const val CONTACT_PHONE_KEY = "CONTACT_PHONE"
    const val FAVORITE_ADDED = "FAVORITE_ADDED"
    const val FAVORITE_REMOVED = "FAVORITE_REMOVED"


    var analyticsInstance: HiAnalyticsInstance? = null

    fun sendEvent(eventName: String, bundleBlock: (Bundle.() -> Unit)? = null) {
        val bundle = bundleBlock?.let { Bundle().apply(it) }
        analyticsInstance?.onEvent(eventName, bundle)
    }

}