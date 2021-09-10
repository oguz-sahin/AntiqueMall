package com.example.antiquemall.ui.home

import androidx.fragment.app.viewModels
import com.example.antiquemall.base.BaseFragment
import com.example.antiquemall.databinding.FragmentHomeBinding
import com.example.antiquemall.ui.vm.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel: HomeViewModel by viewModels()


}