package com.example.antiquemall.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.data.local.DummyProductDatabase
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes.Ads
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 9/9/2021.
 */
@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {


    private val _productsItems = MutableLiveData<ArrayList<ProductListItemTypes>>()
    val productsItems: LiveData<ArrayList<ProductListItemTypes>> get() = _productsItems

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            val products = DummyProductDatabase.getAllProducts()
            val productsListItems = arrayListOf<ProductListItemTypes>()
            productsListItems.addAll(products.subList(0, 4).map { Product(it) })
            productsListItems.add(Ads)
            productsListItems.addAll(products.subList(4, 10).map { Product(it) })
            productsListItems.add(Ads)
            _productsItems.postValue(productsListItems)
        }
    }

}
