package com.example.appui.Activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appui.R
import com.example.appui.databinding.ActivitySpleshActivtiyBinding
import kotlin.concurrent.thread

class SpleshActivtiy : AppCompatActivity() {
    lateinit var binding: ActivitySpleshActivtiyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpleshActivtiyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(Runnable {

            try {
               Thread.sleep(3000)
                //navigret  one activity to another activity
                var intent = Intent(this,LoginActivtiy::class.java)
                startActivity(intent)

            }catch(e:Exception){

            }

        }).start()


    }
}