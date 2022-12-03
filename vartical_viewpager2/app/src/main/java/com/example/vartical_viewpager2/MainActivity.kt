package com.example.vartical_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vartical_viewpager2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}