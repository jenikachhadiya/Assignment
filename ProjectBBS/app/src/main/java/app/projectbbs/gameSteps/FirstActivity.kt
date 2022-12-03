package app.projectbbs.gameSteps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.projectbbs.R
import app.projectbbs.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    lateinit var binding:ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){

    }
}