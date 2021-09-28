package com.example.antiquemall.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.antiquemall.R
import com.example.antiquemall.databinding.ActivityMainBinding
import com.example.antiquemall.util.setVisibility
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
        setNavDestinationListener()
    }

    private fun setUpNavigation() {
        val navController = getNavController()
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.signInFragment,
                R.id.homeFragment,
                R.id.favoritesFragment,
                R.id.profileFragment
            )
        )

        with(binding) {
            bottomNavigationView.setupWithNavController(navController)
            topAppBar.setupWithNavController(navController, appBarConfiguration)
        }

    }

    private fun setNavDestinationListener() {
        val navController = getNavController()
        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.splashFragment -> {
                    setNavigationViewAndAppBarVisibility(
                        isAppBarVisible = false,
                        isNavigationViewVisible = false
                    )

                }
                R.id.signInFragment -> {
                    setNavigationViewAndAppBarVisibility(
                        isAppBarVisible = true,
                        isNavigationViewVisible = false
                    )
                }
                else -> {
                    setNavigationViewAndAppBarVisibility(
                        isAppBarVisible = true,
                        isNavigationViewVisible = true
                    )
                }
            }
        }
    }


    private fun getNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragmentContainer) as NavHostFragment
        return navHostFragment.navController
    }


    private fun setNavigationViewAndAppBarVisibility(
        isAppBarVisible: Boolean,
        isNavigationViewVisible: Boolean
    ) {
        with(binding) {
            topAppBar.setVisibility(isAppBarVisible)
            bottomNavigationView.setVisibility(isNavigationViewVisible)
        }

    }

}