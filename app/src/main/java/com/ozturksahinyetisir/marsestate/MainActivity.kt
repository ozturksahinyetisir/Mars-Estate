package com.ozturksahinyetisir.marsestate

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import com.ozturksahinyetisir.marsestate.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController


        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    Log.e(TAG,"nav_home clicked")
                }
                R.id.nav_settings -> {
                    Log.e(TAG,"nav_settings clicked")
                }
                R.id.nav_exit -> {
                    this.finish()
                    exitProcess(0)

                    return@OnNavigationItemSelectedListener true
                }

            }
            return@OnNavigationItemSelectedListener false

        })
    }

}

/**
 * nav_menu comes from right side of screen. There is 3 menu items. Exit button uses finish activity and app.
 */






