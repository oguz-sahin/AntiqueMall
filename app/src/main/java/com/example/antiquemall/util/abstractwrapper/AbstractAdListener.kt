package com.example.antiquemall.util.abstractwrapper

import com.example.antiquemall.util.manager.AnalyticsManager
import com.example.antiquemall.util.manager.AnalyticsManager.ADS_CLICKED
import com.example.antiquemall.util.manager.AnalyticsManager.ADS_CLOSED
import com.huawei.hms.ads.AdListener

/**
 * Created by Oguz Sahin on 9/10/2021.
 */

abstract class AbstractAdListener : AdListener() {
    override fun onAdClicked() {
        super.onAdClicked()
        AnalyticsManager.sendEvent(ADS_CLICKED)
    }

    override fun onAdClosed() {
        super.onAdClosed()
        AnalyticsManager.sendEvent(ADS_CLOSED)
    }

}