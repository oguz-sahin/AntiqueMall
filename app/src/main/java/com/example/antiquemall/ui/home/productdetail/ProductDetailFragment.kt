package com.example.antiquemall.ui.home.productdetail

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseFragmentWithViewModel
import com.example.antiquemall.data.model.Product
import com.example.antiquemall.data.model.UserTypes.*
import com.example.antiquemall.databinding.FragmentProductDetailBinding
import com.example.antiquemall.ui.MainActivity
import com.example.antiquemall.ui.common.ZoomOutPageTransformer
import com.example.antiquemall.ui.home.productdetail.ProductDetailTabTypes.PRODUCT_INFO
import com.example.antiquemall.ui.home.productdetail.ProductDetailTabTypes.SELLER_LOCATION
import com.example.antiquemall.ui.vm.ProductDetailViewModel
import com.example.antiquemall.util.hasPermissions
import com.example.antiquemall.util.makePhoneCall
import com.example.antiquemall.util.manager.AnalyticsManager.CONTACT_PHONE_KEY
import com.example.antiquemall.util.manager.AnalyticsManager.GET_CONTACT_CLICKED
import com.example.antiquemall.util.manager.AnalyticsManager.sendEvent
import com.example.antiquemall.util.observe
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.huawei.hms.analytics.type.HAEventType.*
import com.huawei.hms.analytics.type.HAParamType.*

class ProductDetailFragment :
    BaseFragmentWithViewModel<FragmentProductDetailBinding, ProductDetailViewModel>(
        FragmentProductDetailBinding::inflate
    ) {

    override val viewModel: ProductDetailViewModel by viewModels()

    private val args: ProductDetailFragmentArgs by navArgs()

    private val photosAdapter = PhotosAdapter()

    private var sellerPhone: String? = null

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                requireContext().makePhoneCall(sellerPhone)
            } else {
                showError(R.string.call_permission_message)
            }
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setProductDetail(args.productId)
    }


    override fun initObserver() {
        super.initObserver()
        observe(viewModel.product) {
            setTitle(it.name)
            setProductDetailTabs(it)
            setPhotos(it.photoUrls)
            sellerPhone = it.seller.phone
        }

        observe(viewModel.isFavorite, ::setFavoriteButton)
    }


    override fun initListener() {
        binding.btnGetContact.setOnClickListener {
            sendEvent(eventName = GET_CONTACT_CLICKED) { putString(CONTACT_PHONE_KEY, sellerPhone) }
            when (viewModel.getUserType()) {
                SIGNED -> makeCall()
                GUEST -> showError(R.string.guess_user_call_error)
            }
        }

        binding.btnAddFavorite.setOnClickListener {
            viewModel.changeFavoriteStatus()
        }
    }

    private fun setTitle(name: String) {
        (activity as MainActivity).setAppBarTitle(name)
    }

    private fun setPhotos(photosUrls: List<String>) {
        with(binding) {
            vpProductPhotos.adapter = photosAdapter
            dotsIndicator.setViewPager2(vpProductPhotos)
        }

        photosAdapter.photos = photosUrls
    }


    private fun setProductDetailTabs(product: Product) {
        with(binding.vpProductDetail) {
            adapter = ProductDetailPagerAdapter(
                product = product,
                location = viewModel.getSellerLocation(),
                fragment = this@ProductDetailFragment
            )
            isUserInputEnabled = false
            setPageTransformer(ZoomOutPageTransformer())
            setProductDetailTabLayout()
        }
    }

    private fun setProductDetailTabLayout() {
        TabLayoutMediator(binding.tlProductDetail, binding.vpProductDetail) { tab, position ->
            when (position) {
                PRODUCT_INFO.positionIndex -> {
                    tab.setTab(title = PRODUCT_INFO.title, icon = PRODUCT_INFO.icon)
                }
                SELLER_LOCATION.positionIndex -> {
                    tab.setTab(title = SELLER_LOCATION.title, icon = SELLER_LOCATION.icon)
                }
                else -> throw Exception("Unknown tab position")
            }
        }.attach()
    }


    private fun makeCall() {
        if (requireContext().hasPermissions(Manifest.permission.CALL_PHONE)) {
            requireContext().makePhoneCall(sellerPhone)
        } else {
            requestPermission.launch(Manifest.permission.CALL_PHONE)
        }
    }


    private fun setFavoriteButton(isFavorite: Boolean) {
        binding.btnAddFavorite.text =
            if (isFavorite) getString(R.string.remove_favorites) else getString(R.string.add_favorites)
    }

    private fun TabLayout.Tab.setTab(@StringRes title: Int, @DrawableRes icon: Int) {
        setText(title)
        setIcon(icon)
    }
}