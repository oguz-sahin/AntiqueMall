package com.example.antiquemall

import android.app.Application
import com.example.antiquemall.util.manager.AnalyticsManager
import com.huawei.agconnect.crash.AGConnectCrash
import com.huawei.hms.ads.HwAds
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsTools
import com.huawei.hms.maps.MapsInitializer
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Oguz Sahin on 9/7/2021.
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupAnalytics()
        initCrashService()
        initAdsKit()
        setMapApiKey()
    }

    private fun setupAnalytics() {
        HiAnalytics.getInstance(this).also {
            AnalyticsManager.analyticsInstance = it
        }.run {
            HiAnalyticsTools.enableLog()
            setAnalyticsEnabled(true)
        }
    }


    private fun initCrashService() {
        AGConnectCrash.getInstance().enableCrashCollection(true)
    }

    private fun initAdsKit() {
        HwAds.init(this)
    }


    private fun setMapApiKey() {
        MapsInitializer.setApiKey(BuildConfig.MAP_API_KEY)
    }


}