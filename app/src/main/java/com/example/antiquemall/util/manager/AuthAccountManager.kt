package com.example.antiquemall.util.manager

import com.example.antiquemall.data.model.UserInfo
import com.example.antiquemall.util.ext.getOrDefault
import com.huawei.hms.support.account.result.AuthAccount

/**
 * Created by Oguz Sahin on 9/9/2021.
 */
object AuthAccountManager {

     var authAccount: AuthAccount? = null

    fun isUserSignIn() = authAccount != null

    fun getUserInfo(): UserInfo = authAccount.let {
        UserInfo(
            name = it?.displayName.getOrDefault(),
            mail = it?.email.getOrDefault(),
            imageUri = it?.avatarUriString.getOrDefault()
        )
    }
}