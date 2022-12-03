package com.example.session_manegment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.session_manegment.R
import com.example.session_manegment.SharePrefrence.Prefrence
import com.example.session_manegment.databinding.ActivitySplashBinding

class Splash_Activity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(Runnable{
            //set time in splsh screen
            Thread.sleep(3000)

            //set manger
            var manger = Prefrence(this)

            if (manger.getLoginStatus()){
                //navigration to home activity
                startActivity(Intent(applicationContext,Home_Activity::class.java))

            }else{
                //navigration to login activity
                startActivity(Intent(applicationContext,Login_Activity::class.java))
            }
        }).start()


    }
}