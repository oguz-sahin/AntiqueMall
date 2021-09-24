package com.example.antiquemall.util.abstractwrapper

import com.example.antiquemall.util.manager.AnalyticsManager.ADS_CLICKED
import com.example.antiquemall.util.manager.AnalyticsManager.ADS_CLOSED
import com.example.antiquemall.util.manager.AnalyticsManager.sendEvent
import com.huawei.hms.ads.AdListener

/**
 * Created by Oguz Sahin on 9/10/2021.
 */

abstract class AbstractAdListener : AdListener() {
    override fun onAdClicked() {
        super.onAdClicked()
        sendEvent(ADS_CLICKED)
    }

    override fun onAdClosed() {
        super.onAdClosed()
        sendEvent(ADS_CLOSED)
    }

}