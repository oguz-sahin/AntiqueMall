package com.example.antiquemall.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.example.antiquemall.data.model.Product
import com.example.antiquemall.databinding.ItemProductBinding

/**
 * Created by Oguz Sahin on 9/24/2021.
 */
class ProductViewHolder(
    private val binding: ItemProductBinding,
    private val onProductItemClickListener: ((productId: Int) -> Unit)?
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(product: Product) {
        with(binding) {
            root.setOnClickListener { onProductItemClickListener?.invoke(product.id) }
            itemProduct = product
            executePendingBindings()
        }
    }

}