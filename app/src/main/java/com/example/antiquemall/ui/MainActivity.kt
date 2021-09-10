package com.example.antiquemall.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.antiquemall.R
import com.example.antiquemall.databinding.ActivityMainBinding
import com.example.antiquemall.util.gone
import com.example.antiquemall.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        setUpNavigation()
        setNavMenuVisibility()
    }

    private fun setUpNavigation() {
        val navController = getNavController()
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun setNavMenuVisibility() {
        val navController = getNavController()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment, R.id.signInFragment -> {
                    binding.bottomNavigationView.gone()
                }
                else -> {
                    binding.bottomNavigationView.visible()
                }
            }
        }
    }


    private fun getNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
        return navHostFragment.navController
    }
}