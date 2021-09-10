package com.example.antiquemall.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseFragment.SnackBarType.ERROR
import com.example.antiquemall.base.BaseFragment.SnackBarType.SUCCESS
import com.example.antiquemall.util.manager.AnalyticsManager.sendEvent
import com.example.antiquemall.util.observeEvent
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Oguz Sahin on 9/7/2021.
 */
typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding, out VM : BaseViewModel>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    abstract val viewModel: VM

    open fun initListener() {}

    open fun initObserver() {}

    override fun onStart() {
        super.onStart()
        sendEvent(this.javaClass.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent(viewModel.baseEvent, ::onViewEvent)
        initObserver()
        initListener()
    }


    private fun onViewEvent(event: BaseViewEvent) {
        when (event) {
            is BaseViewEvent.ShowSuccess -> showSuccess(event.message)

            is BaseViewEvent.ShowError -> showError(event.message)

            is BaseViewEvent.ShowConnectionError -> showError(getString(R.string.connection_error))

            is BaseViewEvent.ShowGeneralError -> showError(getString(R.string.general_error))

            is BaseViewEvent.NavigateTo -> navigateDirections(event.directions)

        }
    }

    fun showSuccess(@StringRes message: Int) = showMessage(SUCCESS, getString(message))

    fun showSuccess(message: String) = showMessage(SUCCESS, message)

    fun showError(@StringRes message: Int) = showMessage(ERROR, getString(message))

    fun showError(message: String) = showMessage(ERROR, message)


    fun navigateDirections(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    private fun showMessage(type: SnackBarType, message: String) {
        val backgroundColor = when (type) {
            SUCCESS -> R.color.primary_green_light
            ERROR -> R.color.red_huawei
        }
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            .setBackgroundTint(ContextCompat.getColor(requireContext(), backgroundColor))
            .show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    enum class SnackBarType {
        SUCCESS, ERROR
    }

}