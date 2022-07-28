package com.example.fregmentobj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fregmentobj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)


        var fragment = FirstFre()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fregment_contanar,fragment)
            .commit()

    }
}