package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModal:MainViewModal

    //live data ak obcjerver class che
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModal = ViewModelProvider(this,MainviewmodalFeactory(10)).get(MainViewModal::class.java)
        updatecounter()
        binding.btnPlus.setOnClickListener {
            mainViewModal.increment()
            updatecounter()
        }
        binding.btnMin.setOnClickListener {
          mainViewModal.decriment()
          updatecounter()
        }





    }
   private fun updatecounter(){
       binding.tvCounter.text="${mainViewModal.getcounter()}"
   }
}