package com.example.nav_drew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.nav_drew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var appBarConfiguration:AppBarConfiguration
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navcontroller = findNavController(R.id.fragmentContainerView)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_CartFrg,
                R.id.nav_ProfileFrg,
                R.id.nav_Setting,
                R.id.nav_homefrg,
                R.id.nav_orderFrg
            )

        )

        setupActionBarWithNavController(navcontroller, appBarConfiguration)
        binding.navView.setupWithNavController(navcontroller)
    }


    override fun onSupportNavigateUp(): Boolean {
        var navhostfrgment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navhostfrgment.navController
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

}
