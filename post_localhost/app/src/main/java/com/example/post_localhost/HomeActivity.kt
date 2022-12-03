package com.example.post_localhost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.post_localhost.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }
}