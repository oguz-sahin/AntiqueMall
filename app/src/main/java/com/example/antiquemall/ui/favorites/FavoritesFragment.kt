package com.example.antiquemall.ui.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.antiquemall.base.BaseFragmentWithViewModel
import com.example.antiquemall.databinding.FragmentFavoritesBinding
import com.example.antiquemall.ui.favorites.FavoritesFragmentDirections.actionFavoritesFragmentToProductDetailFragment
import com.example.antiquemall.ui.home.ProductsAdapter
import com.example.antiquemall.ui.vm.FavoritesViewModel
import com.example.antiquemall.util.observe
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoritesFragment : BaseFragmentWithViewModel<FragmentFavoritesBinding, FavoritesViewModel>(
    FragmentFavoritesBinding::inflate
) {
    override val viewModel: FavoritesViewModel by viewModels()

    private val favoritesProductsAdapter = ProductsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBinding()
        initAdapter()
    }

    private fun setBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    override fun initObserver() {
        observe(viewModel.favoritesProductsItems) { productListItems ->
            favoritesProductsAdapter.productsListItems = productListItems
        }
    }

    private fun initAdapter() {
        favoritesProductsAdapter.setOnProductItemCLickListener { productId ->
            val action = actionFavoritesFragmentToProductDetailFragment().also {
                it.productId = productId
            }
            navigateDirections(action)
        }
        binding.rvFavoritesProducts.adapter = favoritesProductsAdapter
    }
}