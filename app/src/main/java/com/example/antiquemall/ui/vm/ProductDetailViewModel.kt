package com.example.antiquemall.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.data.local.DummyProductDatabase
import com.example.antiquemall.data.model.Product
import com.example.antiquemall.data.model.UserTypes
import com.example.antiquemall.util.manager.AnalyticsManager.FAVORITE_ADDED
import com.example.antiquemall.util.manager.AnalyticsManager.FAVORITE_REMOVED
import com.example.antiquemall.util.manager.AnalyticsManager.PRODUCT_KEY
import com.example.antiquemall.util.manager.AnalyticsManager.sendEvent
import com.example.antiquemall.util.manager.AuthAccountManager
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
            val (eventName, isFavorite) = getChangedFavoriteInfo()
            sendEvent(eventName = eventName) { putParcelable(PRODUCT_KEY, product.value) }
            DummyProductDatabase.setProductFavoriteStatus(
                id = product.value!!.id,
                isFavorite = isFavorite
            ) {
                _isFavorite.postValue(isFavorite)
                val messageId =
                    if (isFavorite) R.string.added_favorites else R.string.removed_favorites
                showSuccess(messageId)
            }

        }
    }


    private fun getChangedFavoriteInfo(): Pair<String, Boolean> {
        val eventName = if (isFavorite.value!!) FAVORITE_REMOVED else FAVORITE_ADDED
        return Pair(eventName, isFavorite.value!!.not())
    }


}