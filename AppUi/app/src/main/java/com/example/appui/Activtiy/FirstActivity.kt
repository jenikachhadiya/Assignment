package com.example.appui.Activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appui.R
import com.example.appui.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread(Runnable {
            try {
                Thread.sleep(3000)
                //navigration secondActivity
                var intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)

            } catch (e: Exception) {

            }
        }).start()

    }
}