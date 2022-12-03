package com.example.appui.Activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.appui.R
import com.example.appui.databinding.ActivityLoginActivtiyBinding

class LoginActivtiy : AppCompatActivity() {
    lateinit var binding: ActivityLoginActivtiyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)



      binding.btnSignup.setOnClickListener{

            var intent = Intent(this,SignupActivtiy::class.java)
            startActivity(intent)

        }
//        binding.imgClick.setOnClickListener {
//
//            Toast.makeText(applicationContext, "navigrat to imege page", Toast.LENGTH_SHORT).show()
//
//
//        }


    }
}