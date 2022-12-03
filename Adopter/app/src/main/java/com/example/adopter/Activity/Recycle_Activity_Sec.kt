package com.example.adopter.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adopter.R
import com.example.adopter.databinding.ActivityRecycleSecBinding

class Recycle_Activity_Sec : AppCompatActivity() {
    lateinit var binding: ActivityRecycleSecBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleSecBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}