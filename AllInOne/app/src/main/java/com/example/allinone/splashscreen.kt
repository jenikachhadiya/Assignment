package com.example.allinone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allinone.SharePrefrence.Prefrence
import com.example.allinone.databinding.ActivityRagisterBinding
import com.example.allinone.databinding.ActivitySplashscreenBinding

class splashscreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Thread(Runnable {

            Thread.sleep(3000)

            var manager =Prefrence(this)
            if (manager.getloginstatus()){
                 startActivity(Intent(applicationContext,HomeActivity::class.java))
            }else{
                startActivity(Intent(applicationContext,LoginActivity::class.java))
            }

        }).start()


    }
}