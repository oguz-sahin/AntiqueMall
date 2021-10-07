package com.example.antiquemall.base

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.antiquemall.util.Event

/**
 * Created by Oguz Sahin on 9/9/2021.
 */


abstract class BaseViewModel : ViewModel() {

    /** Internal loading state of ViewModel. Visual representation may differ. **/
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    /** Used for sending one-time signal to observers. **/
    private val _baseEvent = MutableLiveData<Event<BaseViewEvent>>()
    val baseEvent: LiveData<Event<BaseViewEvent>> = _baseEvent

    /** An helper function for sending one-time events to [baseEvent] **/
    private fun sendEvent(event: BaseViewEvent) = _baseEvent.postValue(Event(event))

    fun showLoading() {
        _loading.postValue(true)
    }

    fun hideLoading() {
        _loading.postValue(false)
    }

    /** Navigate to specific direction **/
    fun navigate(directions: NavDirections) = sendEvent(BaseViewEvent.NavigateTo(directions))


    @Suppress("MemberVisibilityCanBePrivate")
    fun showError(message: String) = sendEvent(BaseViewEvent.ShowError(message))

    fun showSuccess(message: String) = sendEvent(BaseViewEvent.ShowSuccess(message))

    fun showSuccess(@StringRes message: Int) = sendEvent(BaseViewEvent.ShowSuccessWithId(message))

    fun showGeneralError() = sendEvent(BaseViewEvent.ShowGeneralError)

    fun showConnectionError() = sendEvent(BaseViewEvent.ShowConnectionError)


}