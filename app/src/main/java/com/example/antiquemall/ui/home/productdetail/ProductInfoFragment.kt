package com.example.antiquemall.ui.home.productdetail

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.antiquemall.base.BaseFragment
import com.example.antiquemall.data.model.Product
import com.example.antiquemall.databinding.FragmentProductInfoBinding

class ProductInfoFragment : BaseFragment<FragmentProductInfoBinding>(
    FragmentProductInfoBinding::inflate
) {

    private var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = arguments?.getParcelable(PRODUCT_KEY)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProductInfo()
    }

    private fun setProductInfo() {
        product?.let {
            binding.product = it
        }
    }


    companion object {
        private const val PRODUCT_KEY = "PRODUCT_KEY"
        fun newInstance(product: Product): ProductInfoFragment {
            return ProductInfoFragment().apply {
                arguments = bundleOf(PRODUCT_KEY to product)
            }
        }
    }

}
