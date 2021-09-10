package com.example.antiquemall.util.manager

import com.example.antiquemall.data.model.UserInfo
import com.example.antiquemall.data.model.UserTypes.GUEST
import com.example.antiquemall.data.model.UserTypes.SIGNED
import com.huawei.hms.support.account.result.AuthAccount

/**
 * Created by Oguz Sahin on 9/9/2021.
 */
object AuthAccountManager {

    private var authAccount: AuthAccount? = null

    fun isUserSignIn() = authAccount != null

    fun getUserInfo(): UserInfo {
        return if (isUserSignIn()) {
            authAccount.let {
                UserInfo(
                    type = SIGNED,
                    name = it!!.displayName,
                    mail = it.email,
                    imageUri = it.avatarUriString
                )
            }
        } else {
            UserInfo(
                type = GUEST,
                name = GUEST.name
            )
        }
    }

    fun removeAutAccount() {
        authAccount = null
    }

    fun setAuthAccount(authAccount: AuthAccount) {
        this.authAccount = authAccount
    }

}