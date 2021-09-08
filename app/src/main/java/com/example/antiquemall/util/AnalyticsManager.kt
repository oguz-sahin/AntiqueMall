package com.example.antiquemall.util

import android.os.Bundle
import com.huawei.hms.analytics.HiAnalyticsInstance

/**
 * Created by Oguz Sahin on 9/8/2021.
 */
object AnalyticsManager {

    var analyticsInstance: HiAnalyticsInstance? = null

    fun sendCustomEvent(eventName: String, bundleBlock: Bundle.() -> Unit) {
        analyticsInstance?.onEvent(eventName, Bundle().apply(bundleBlock))
    }

}