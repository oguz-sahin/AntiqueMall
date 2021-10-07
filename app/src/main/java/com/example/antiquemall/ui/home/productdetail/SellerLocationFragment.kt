package com.example.antiquemall.ui.home.productdetail

import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseMapFragment
import com.example.antiquemall.databinding.FragmentSellerLocationBinding
import com.huawei.hms.maps.CameraUpdateFactory
import com.huawei.hms.maps.MapView
import com.huawei.hms.maps.model.CameraPosition
import com.huawei.hms.maps.model.LatLng
import com.huawei.hms.maps.model.MarkerOptions


class SellerLocationFragment : BaseMapFragment<FragmentSellerLocationBinding>(
    inflate = FragmentSellerLocationBinding::inflate
) {
    override val mapView: MapView
        get() = binding.root

    private var location: LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        location = arguments?.getParcelable(LOCATION_KEY)
    }


    override fun mapReadyFunc() {
        super.mapReadyFunc()
        setSellerLocation(::addMarker)
    }

    private fun setSellerLocation(addMarkerFunc: () -> Unit) {
        val cameraPosition = CameraPosition(location, ZOOM_VALUE, 90F, 60F)
        hMap?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 2000, null)
        addMarkerFunc.invoke()
    }

    private fun addMarker() {
        MarkerOptions()
            .position(location)
            .title(getString(R.string.seller_location))
            .run {
                hMap?.addMarker(this)
            }
    }


    companion object {
        private const val LOCATION_KEY = "LOCATION_KEY"
        private const val ZOOM_VALUE = 20F
        fun newInstance(location: LatLng?): SellerLocationFragment {
            return SellerLocationFragment().apply {
                arguments = bundleOf(LOCATION_KEY to location)
            }
        }
    }


}