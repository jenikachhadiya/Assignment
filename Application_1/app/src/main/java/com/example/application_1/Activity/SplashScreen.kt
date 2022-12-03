package com.example.application_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_1.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var  binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // hold 3second and nevigrate first activity

        if(intent.getBooleanExtra("Exit",false)){
            finish()
        }

        Thread(Runnable {

            try {
                Thread.sleep(3000)
                var intent = Intent(applicationContext,Welcome_Activity::class.java)
                startActivity(intent)

            }catch (e:Exception){

            }
        }).start()

    }
}
