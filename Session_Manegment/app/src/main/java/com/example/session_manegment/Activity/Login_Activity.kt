package com.example.session_manegment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.session_manegment.R
import com.example.session_manegment.databinding.ActivityLoginBinding

class Login_Activity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            //navigration to home activtiy
            startActivity(Intent(applicationContext,Home_Activity::class.java))

        }

        binding.btnSignup.setOnClickListener {
            //navigration to home activity
            startActivity(Intent(applicationContext,Signup_Activity::class.java))

        }

    }
}