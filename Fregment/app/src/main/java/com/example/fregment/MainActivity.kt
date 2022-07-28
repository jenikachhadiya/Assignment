package com.example.fregment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fregment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private  lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container,FirstFragment())
                .commit()




       // var fregment = FirstFragment()






    }


}