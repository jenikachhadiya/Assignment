package com.example.appui.Activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.appui.R
import com.example.appui.databinding.ActivityAppSactivityBinding

class App_S_Activity : AppCompatActivity() {
    lateinit var binding: ActivityAppSactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppSactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignup.setOnClickListener {

            //navigration to singup page
            var intent = Intent(this,App_For_Activity::class.java)
            startActivity(intent)
        }
        binding.btnSignin.setOnClickListener {

            var intent = Intent(this,App_T_Activity::class.java)
            startActivity(intent)
        }

    }
}