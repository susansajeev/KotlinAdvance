package com.aspire.mykotlicour.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aspire.mykotlicour.R
import com.aspire.mykotlicour.databinding.ActivityHomePageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)?.findNavController()
            ?: findNavController(R.id.nav_host_fragment_container)
        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.navto_add_list)
                }
                R.id.nav_search -> {
                    navController.navigate(R.id.navto_list_add)
                }
            }
            true
        }

    }


}