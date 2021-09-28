package com.example.antiquemall.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.antiquemall.R
import com.example.antiquemall.databinding.ItemAdsBinding
import com.example.antiquemall.databinding.ItemProductBinding
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes.Ads
import com.example.antiquemall.ui.home.ProductsAdapter.ProductListItemTypes.Product


/**
 * Created by Oguz Sahin on 9/24/2021.
 */
class ProductsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var productsListItems = mutableListOf<ProductListItemTypes>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    private var onProductItemClickListener: ((productId: Int) -> Unit)? = null

    fun setOnProductItemCLickListener(onProductItemClickListener: ((productId: Int) -> Unit)?) {
        this.onProductItemClickListener = onProductItemClickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_ads -> {
                val binding =
                    ItemAdsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                AdsViewHolder(binding)
            }
            R.layout.item_product -> {
                val binding =
                    ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ProductViewHolder(binding, onProductItemClickListener)
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> {
                (productsListItems[position] as Product).also {
                    holder.bind(it.product)
                }
            }

            is AdsViewHolder -> holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (productsListItems[position]) {
            is Ads -> R.layout.item_ads
            is Product -> R.layout.item_product
        }
    }

    override fun getItemCount(): Int = productsListItems.size


    sealed class ProductListItemTypes {
        object Ads : ProductListItemTypes()
        data class Product(val product: com.example.antiquemall.data.model.Product) :
            ProductListItemTypes()
    }
}