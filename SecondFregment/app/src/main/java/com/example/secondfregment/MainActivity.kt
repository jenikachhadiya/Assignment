package com.example.secondfregment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondfregment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //main activity to fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.Fregment_Contanier,FirstFregment())
            .commit()


    }
}