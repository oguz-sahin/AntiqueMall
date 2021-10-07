package com.example.antiquemall.util.ext

import com.example.antiquemall.util.abstractwrapper.AbstractAdListener
import com.huawei.hms.ads.AdParam
import com.huawei.hms.ads.BannerAdSize
import com.huawei.hms.ads.banner.BannerView

/**
 * Created by Oguz Sahin on 9/24/2021.
 */


fun BannerView.loadAds() {
    adId = "testw6vs28auh3"
    bannerAdSize = BannerAdSize.BANNER_SIZE_360_57
    setBannerRefresh(30)
    adListener = object : AbstractAdListener() {}
    loadAd(AdParam.Builder().build())
}