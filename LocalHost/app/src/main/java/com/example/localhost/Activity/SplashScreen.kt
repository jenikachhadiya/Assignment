package com.example.localhost.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.localhost.Shareprefrence.PrefrenceClass
import com.example.localhost.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        inititon()



    }

    private fun inititon() {
       /* Thread(Runnable {
            Thread.sleep(2000)

            var manger = PrefrenceClass(this)

            if (!manger.getlogin()) {
                Toast.makeText(this, "if(Home)", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,LoginActivity::class.java))
                finish()

            }else{
                if(manger.getlogin()){
                    Toast.makeText(this, "else(Login)", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this ,HomeActivity::class.java))
                    finish()
                }

            }


        }).start()*/





        Handler().postDelayed({
            var prefManager = PrefrenceClass(this)

            if (!prefManager.getlogin()) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                if (prefManager.getlogin()) {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }

        }, 1000)

    }
}