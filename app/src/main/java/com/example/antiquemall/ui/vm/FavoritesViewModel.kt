package com.example.antiquemall.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.data.local.DummyProductDatabase
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 9/27/2021.
 */


@HiltViewModel
class FavoritesViewModel @Inject constructor() : BaseViewModel() {

    private val _favoritesProductsItems = MutableLiveData<MutableList<ProductListItemTypes>>()
    val favoritesProductsItems: LiveData<MutableList<ProductListItemTypes>> get() = _favoritesProductsItems

    val isFavoriteProductsEmpty = Transformations.map(favoritesProductsItems) { it.isEmpty() }

    init {
        getFavoritesProducts()
    }

    private fun getFavoritesProducts() {
        viewModelScope.launch {
            val favoritesProducts = DummyProductDatabase.getFavoritesProducts()
            _favoritesProductsItems.postValue(favoritesProducts.map { Product(it) }.toMutableList())
        }
    }
}