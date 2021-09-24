package com.example.antiquemall.ui.vm

import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.ui.splash.SplashFragmentDirections
import com.example.antiquemall.ui.splash.SplashFragmentDirections.actionSplashFragmentToHomeFragment
import com.example.antiquemall.ui.splash.SplashFragmentDirections.actionSplashFragmentToSignInFragment
import com.example.antiquemall.util.manager.AuthAccountManager.setAuthAccount
import com.huawei.hms.support.account.service.AccountAuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 9/8/2021.
 */

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val accountAuthService: AccountAuthService
) : BaseViewModel() {

    fun signInSilent() {
        accountAuthService.silentSignIn()
            .addOnSuccessListener { autAccount ->
                setAuthAccount(autAccount)
                navigate(actionSplashFragmentToHomeFragment())
            }.addOnFailureListener {
                navigate(actionSplashFragmentToSignInFragment())
            }
    }

}