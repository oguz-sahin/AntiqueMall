package com.example.antiquemall.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseFragmentWithViewModel
import com.example.antiquemall.databinding.FragmentHomeBinding
import com.example.antiquemall.ui.home.HomeFragmentDirections.actionHomeFragmentToProductDetailFragment
import com.example.antiquemall.ui.vm.HomeViewModel
import com.example.antiquemall.util.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragmentWithViewModel<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel: HomeViewModel by viewModels()

    private val productsAdapter = ProductsAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()

    }

    override fun initObserver() {
        observe(viewModel.productsItems) { productListItems ->
            productsAdapter.productsListItems = productListItems
        }
    }

    private fun initAdapter() {
        productsAdapter.setOnProductItemCLickListener { productId ->
            val action = actionHomeFragmentToProductDetailFragment().also {
                it.productId = productId
            }
            navigateDirections(action)
        }

        val layoutManager = GridLayoutManager(requireContext(), 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (productsAdapter.getItemViewType(position)) {
                    R.layout.item_ads -> PRODUCT_SPAN_COUNT
                    R.layout.item_product -> ADS_SPAN_COUNT
                    else -> throw IllegalStateException("Unknown view type")
                }
            }
        }
        with(binding) {
            rvProducts.layoutManager = layoutManager
            rvProducts.adapter = productsAdapter
        }
    }


    companion object {
        private const val ADS_SPAN_COUNT = 1
        private const val PRODUCT_SPAN_COUNT = 2
    }

}