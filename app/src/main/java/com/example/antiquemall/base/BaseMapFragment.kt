package com.example.antiquemall.base

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.huawei.hms.maps.HuaweiMap
import com.huawei.hms.maps.MapView
import com.huawei.hms.maps.OnMapReadyCallback

/**
 * Created by Oguz Sahin on 10/5/2021.
 */
abstract class BaseMapFragment<VB : ViewBinding>(
    inflate: Inflate<VB>
) : BaseFragment<VB>(inflate), OnMapReadyCallback {

    protected var hMap: HuaweiMap? = null

    open fun mapReadyFunc() {}

    abstract val mapView: MapView


    override fun onMapReady(map: HuaweiMap?) {
        hMap = map
        mapReadyFunc()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }
        mapView.onCreate(mapViewBundle)
        mapView.getMapAsync(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY)
        if (mapViewBundle == null) {
            mapViewBundle = Bundle().also { outState.putBundle(MAPVIEW_BUNDLE_KEY, it) }

        }
        mapView.onSaveInstanceState(mapViewBundle)
    }


    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }


    companion object {
        private const val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    }
}