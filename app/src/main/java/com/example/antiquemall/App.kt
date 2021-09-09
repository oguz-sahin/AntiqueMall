package com.example.antiquemall

import android.app.Application
import com.example.antiquemall.util.manager.AnalyticsManager
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsTools
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Oguz Sahin on 9/7/2021.
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupAnalytics()
    }

    private fun setupAnalytics() {
        HiAnalytics.getInstance(this).also {
            AnalyticsManager.analyticsInstance = it
        }.run {
            HiAnalyticsTools.enableLog()
            setAnalyticsEnabled(true)
        }
    }
}