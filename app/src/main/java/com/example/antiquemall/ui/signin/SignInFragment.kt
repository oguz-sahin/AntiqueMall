package com.example.antiquemall.ui.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.antiquemall.R
import com.example.antiquemall.base.BaseFragment
import com.example.antiquemall.databinding.FragmentSigninBinding
import com.example.antiquemall.util.showToast
import com.huawei.hms.support.account.service.AccountAuthService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSigninBinding, SignInViewModel>(
    FragmentSigninBinding::inflate
) {

    @Inject
    lateinit var accountAuthService: AccountAuthService

    override val viewModel: SignInViewModel by viewModels()

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setResultLauncher()
    }

    private fun setResultLauncher() {
        resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
            viewModel.signIn(result)
        }
    }

    override fun initListener() {
        with(binding) {
            btnSignInWithHuawei.setOnClickListener {
                signInHuaweiId()
            }
            btnContinueWithoutSignIn.setOnClickListener {
                showRememberDialog()
            }
        }
    }

    private fun signInHuaweiId() {
        resultLauncher.launch(accountAuthService.signInIntent)
    }

    private fun showRememberDialog() {
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setTitle(getString(R.string.warning))
            .setMessage(getString(R.string.remember_sign_in_messeage))
            .setIcon(R.drawable.ic_warning)
            .setCancelable(true)
            .setPositiveButton(
                getString(R.string.yes)
            ) { _, _ ->
                showToast("devam et tıklandı")
            }.setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.cancel()
            }
            .create()
            .show()
    }

}