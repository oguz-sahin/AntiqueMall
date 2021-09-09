package com.example.antiquemall.ui.splash

import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.util.manager.AuthAccountManager
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
            .addOnSuccessListener {
                AuthAccountManager.authAccount = it
            }.addOnFailureListener {
                navigate(SplashFragmentDirections.actionSplashFragmentToSignInFragment())
            }
    }

}