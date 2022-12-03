package com.example.amazon.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amazon.R
import com.example.amazon.databinding.ActivitySplashBinding

class Splash_Activity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread(Runnable {
            try {
            Thread.sleep(3000)
                var intent = Intent(applicationContext,Second_Activity::class.java)
                startActivity(intent)

            }catch (e:Exception){

            }

        }).start()


    }
}