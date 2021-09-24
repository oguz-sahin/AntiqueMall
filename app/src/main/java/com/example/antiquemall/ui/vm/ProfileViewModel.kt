package com.example.antiquemall.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.antiquemall.base.BaseViewModel
import com.example.antiquemall.data.model.UserInfo
import com.example.antiquemall.ui.profile.ProfileFragmentDirections
import com.example.antiquemall.ui.profile.ProfileFragmentDirections.actionProfileFragmentToSignInFragment
import com.example.antiquemall.util.manager.AnalyticsManager.sendEvent
import com.example.antiquemall.util.manager.AuthAccountManager.getUserInfo
import com.example.antiquemall.util.manager.AuthAccountManager.removeAutAccount
import com.huawei.hms.analytics.type.HAEventType.SIGNOUT
import com.huawei.hms.support.account.service.AccountAuthService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Oguz Sahin on 9/9/2021.
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val accountAuthService: AccountAuthService
) : BaseViewModel() {

    private val _userInfo = MutableLiveData<UserInfo>()
    val userInfo: LiveData<UserInfo> get() = _userInfo

    init {
        _userInfo.postValue(getUserInfo())
    }

    fun signOut() {
        accountAuthService.signOut()
            .addOnSuccessListener {
                sendEvent(SIGNOUT)
                removeAutAccount()
                navigate(actionProfileFragmentToSignInFragment())
            }.addOnFailureListener {
                showGeneralError()
            }
    }

}
