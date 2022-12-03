package com.example.application_1.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.application_1.R
import com.example.application_1.databinding.ActivitySecondBinding

class Second_Activity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Thread(Runnable {
            try {
                Thread.sleep(2000)

                var intent = Intent(applicationContext,Third_Activity::class.java)
                startActivity(intent)

            }catch (e:Exception){

            }



        }).start()

    }

}