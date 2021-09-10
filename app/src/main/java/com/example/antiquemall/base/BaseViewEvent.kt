package com.example.antiquemall.base

import androidx.navigation.NavDirections

/**
 * Created by Oguz Sahin on 9/8/2021.
 */
sealed class BaseViewEvent {

    data class ShowError(val message: String) : BaseViewEvent()

    data class ShowSuccess(val message: String) : BaseViewEvent()

    object ShowGeneralError : BaseViewEvent()

    object ShowConnectionError : BaseViewEvent()

    data class NavigateTo(val directions: NavDirections) : BaseViewEvent()

}