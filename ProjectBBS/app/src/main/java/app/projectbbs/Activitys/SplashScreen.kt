package app.projectbbs.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.projectbbs.Activitys.Home.HomeActivity
import app.projectbbs.MainActivity
import app.projectbbs.R
import app.projectbbs.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread(Runnable {
            try {
                Thread.sleep(1000)
                var intent = Intent(applicationContext,HomeActivity::class.java)
                startActivity(intent)
            }catch (e:Exception){

            }

        }).start()


    }
}