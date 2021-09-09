package com.example.antiquemall.ui.signin

import android.app.Activity
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.lifecycle.viewModelScope
import com.example.antiquemall.base.BaseViewModel
import com.huawei.hms.common.ApiException
import com.huawei.hms.support.account.AccountAuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 9/9/2021.
 */

@HiltViewModel
class SignInViewModel @Inject constructor() : BaseViewModel() {

    fun signIn(result: ActivityResult) {
        viewModelScope.launch {
            if (result.resultCode == Activity.RESULT_OK) {
                val authAccountTask = AccountAuthManager.parseAuthResultFromIntent(result.data)
                if (authAccountTask.isSuccessful) {
                    // The sign-in is successful, and the user's ID information and ID token are obtained.
                    val authAccount = authAccountTask.result
                    Log.i(this::class.java.simpleName, "idToken:" + authAccount.idToken)
                } else {
                    // The sign-in failed. No processing is required. Logs are recorded for fault locating.
                    showError("sign in failed : " + (authAccountTask.exception as ApiException).statusCode)
                }
            } else {
                showGeneralError()
            }
        }
    }
}
