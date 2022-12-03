package com.example.appui.Activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appui.R
import com.example.appui.databinding.ActivityAppFactivityBinding

class App_F_Activity : AppCompatActivity() {
    lateinit var binding: ActivityAppFactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppFactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(Runnable {
             try {
                 Thread.sleep(3000)
                 //navigtation to secondpage
                 var intent = Intent(this,App_T_Activity::class.java)
                 startActivity(intent)
             }catch (e:Exception){

             }

        }).start()

    }
}