package com.example.antiquemall.ui.home.productdetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.antiquemall.data.model.Product
import com.example.antiquemall.ui.home.productdetail.ProductDetailTabTypes.PRODUCT_INFO
import com.example.antiquemall.ui.home.productdetail.ProductDetailTabTypes.SELLER_LOCATION
import com.huawei.hms.maps.model.LatLng

/**
 * Created by Oguz Sahin on 10/4/2021.
 */
class ProductDetailPagerAdapter(
    private val product: Product,
    private val location: LatLng?,
    fragment: Fragment
) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT_INFO.positionIndex -> ProductInfoFragment.newInstance(product)
            SELLER_LOCATION.positionIndex -> SellerLocationFragment.newInstance(location)
            else -> throw Exception("Unknown tab position")
        }
    }

    companion object {
        private const val NUM_PAGES = 2
    }
}