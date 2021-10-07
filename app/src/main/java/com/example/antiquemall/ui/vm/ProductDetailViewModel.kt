package com.example.antiquemall.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.data.local.DummyProductDatabase
import com.example.antiquemall.data.model.Product
import com.example.antiquemall.data.model.UserTypes
import com.example.antiquemall.util.manager.AnalyticsManager
import com.example.antiquemall.util.manager.AnalyticsManager.DELETE_PRODUCT_TO_WISHLIST
import com.example.antiquemall.util.manager.AnalyticsManager.PRICE_KEY
import com.example.antiquemall.util.manager.AnalyticsManager.PRODUCT_ID_KEY
import com.example.antiquemall.util.manager.AnalyticsManager.PRODUCT_NAME_KEY
import com.example.antiquemall.util.manager.AnalyticsManager.sendEvent
import com.example.antiquemall.util.manager.AuthAccountManager
import com.huawei.hms.analytics.type.HAEventType
import com.huawei.hms.analytics.type.HAEventType.ADDPRODUCT2WISHLIST
import com.huawei.hms.analytics.type.HAParamType.*
import com.huawei.hms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 9/28/2021.
 */

@HiltViewModel
class ProductDetailViewModel @Inject constructor() : BaseViewModel() {

    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product


    private val _isFavorite: MutableLiveData<Boolean> = MutableLiveData()
    val isFavorite: LiveData<Boolean> get() = _isFavorite


    fun setProductDetail(productId: Int) {
        viewModelScope.launch {
            DummyProductDatabase.getProductById(productId)?.let {
                sendProductViewedEvent(it)
                _product.postValue(it)
                _isFavorite.postValue(it.isFavorite)
            } ?: run {
                showError("No found product")
            }
        }
    }

    fun getUserType(): UserTypes = AuthAccountManager.getUserInfo().type


    fun getSellerLocation(): LatLng? {
        return product.value?.seller?.let { seller ->
            LatLng(seller.latitude, seller.longitude)
        } ?: run { null }
    }

    fun changeFavoriteStatus() {
        if (isFavorite.value == null || product.value?.id == null) {
            showGeneralError()
        } else {
            val isFavorite = isFavorite.value!!.not()
            DummyProductDatabase.setProductFavoriteStatus(
                id = product.value!!.id,
                isFavorite = isFavorite
            ) {
                _isFavorite.postValue(isFavorite)
                val messageId =
                    if (isFavorite) R.string.added_favorites else R.string.removed_favorites
                sendFavoriteStatusEvent(isFavorite)
                showSuccess(messageId)
            }

        }
    }

    private fun sendFavoriteStatusEvent(isFavorite: Boolean) {
        val (price, productId, productName) = product.value!!.let {
            Triple(it.price, it.id, it.name)
        }
        if (isFavorite) {
            sendEvent(eventName = ADDPRODUCT2WISHLIST) {
                putString(PRICE, price.toString())
                putString(PRODUCTID, productId.toString())
                putString(PRODUCTNAME, productName)
            }
        } else {
            sendEvent(eventName = DELETE_PRODUCT_TO_WISHLIST) {
                putString(PRICE_KEY, price.toString())
                putString(PRODUCT_ID_KEY, productId.toString())
                putString(PRODUCT_NAME_KEY, productName)
            }
        }
    }


    private fun sendProductViewedEvent(product: Product) {
        sendEvent(eventName = HAEventType.VIEWPRODUCT) {
            putString(AnalyticsManager.CITY_KEY, product.seller.city)
            putString(PRICE, product.price.toString())
            putString(PRODUCTID, product.id.toString())
            putString(PRODUCTNAME, product.name)
        }

    }


}