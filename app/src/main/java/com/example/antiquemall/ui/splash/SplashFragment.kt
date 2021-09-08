package com.example.antiquemall.ui.splash

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.antiquemall.base.BaseFragment
import com.example.antiquemall.databinding.FragmentSplashBinding
import com.example.antiquemall.util.AbstractAnimationListener
import com.example.antiquemall.util.goneStatusBar


class SplashFragment : BaseFragment<FragmentSplashBinding>(
    inflate = FragmentSplashBinding::inflate
) {
    private val viewModel: SplashViewModel by viewModels()
    private val logoEndAnimationListener = object : AbstractAnimationListener() {
        override fun onAnimationEnd(animation: Animation?) {
            playTextAnimation()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().goneStatusBar()
        lifecycleScope.launchWhenCreated {
            playLogoAnimation()
        }
    }

    private fun playLogoAnimation() {
        with(binding.ivLogo) {
            TranslateAnimation(0f, 0f, this.height.toFloat() - 200f, 0f).apply {
                duration = 500
                fillAfter = true
                setAnimationListener(logoEndAnimationListener)
            }.run {
                startAnimation(this)
            }
        }

    }

    private fun playTextAnimation() {
        binding.tvSlogan.animate()
            .alpha(1.0f)
            .duration = 500
    }

}
