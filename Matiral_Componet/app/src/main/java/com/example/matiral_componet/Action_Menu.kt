package com.example.matiral_componet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.matiral_componet.databinding.ActivityActionMenuBinding

class Action_Menu : AppCompatActivity() {
    lateinit var binding: ActivityActionMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActionMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.topAppBar.setNavigationOnClickListener {
           binding.drawerlayout.open()
        }
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
                // Handle menu item selected
                menuItem.isChecked = true
                binding.drawerlayout.close()
                true
            }


        }
    }
