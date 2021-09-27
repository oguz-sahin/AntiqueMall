package com.example.antiquemall.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseFragment
import com.example.antiquemall.data.model.UserInfo
import com.example.antiquemall.data.model.UserTypes.GUEST
import com.example.antiquemall.data.model.UserTypes.SIGNED
import com.example.antiquemall.databinding.FragmentProfileBinding
import com.example.antiquemall.ui.vm.ProfileViewModel
import com.example.antiquemall.util.ext.loadAds
import com.example.antiquemall.util.observe
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(
    FragmentProfileBinding::inflate
) {
    override val viewModel: ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAds()
    }

    override fun initObserver() {
        super.initObserver()
        observe(viewModel.userInfo, ::setUserInfo)
    }


    override fun initListener() {
        super.initListener()
        with(binding) {
            bgExit.setOnClickListener {
                viewModel.signOut()
            }
        }
    }

    private fun loadAds() {
        binding.hwBannerView.loadAds()
    }


    private fun setUserInfo(userInfo: UserInfo) {
        when (userInfo.type) {
            GUEST -> {
                binding.ivUserImage.setImageResource(R.drawable.ic_person)
            }
            SIGNED -> {
                binding.tvUserMail.text = userInfo.mail
                Glide.with(requireContext()).load(userInfo.imageUri).into(binding.ivUserImage)
            }
        }
        binding.tvUserName.text = userInfo.name
    }
}