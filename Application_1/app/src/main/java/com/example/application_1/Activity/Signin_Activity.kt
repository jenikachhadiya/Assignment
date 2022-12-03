package com.example.application_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_1.R
import com.example.application_1.databinding.ActivitySigninBinding

class Signin_Activity : AppCompatActivity() {
    lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySigninBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.ivBack.setOnClickListener {

            //navigration back side
            var intent = Intent(applicationContext,Welcome_Activity::class.java)
            startActivity(intent)

        }
        binding.ivClose.setOnClickListener {

            //close this page and aPP
            var intent = Intent(applicationContext,SplashScreen::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("Exit",true)
            startActivity(intent)
            finish()


        }



    }

}


