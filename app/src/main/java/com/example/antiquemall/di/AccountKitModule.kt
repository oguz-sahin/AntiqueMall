package com.example.antiquemall.di

import android.content.Context
import com.huawei.hms.support.account.AccountAuthManager
import com.huawei.hms.support.account.request.AccountAuthParams
import com.huawei.hms.support.account.request.AccountAuthParamsHelper
import com.huawei.hms.support.account.service.AccountAuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Oguz Sahin on 9/9/2021.
 */

@Module
@InstallIn(SingletonComponent::class)
object AccountKitModule {

    @Provides
    @Singleton
    fun provideAccountAuthService(
        @ApplicationContext context: Context
    ): AccountAuthService {
        val accountAuthParams =
            AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
                .setIdToken()
                .createParams()
        return AccountAuthManager.getService(context, accountAuthParams)
    }

}