package com.example.application_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_1.R
import com.example.application_1.databinding.ActivityWelcomeBinding

class Welcome_Activity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(Runnable {

            try {
                Thread.sleep(2000)

                var intent = Intent(applicationContext,Second_Activity::class.java)
                startActivity(intent)

            }catch (e:Exception){

            }



        }).start()



    }
}