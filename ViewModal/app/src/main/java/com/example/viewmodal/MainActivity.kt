package com.example.viewmodal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //create enstence of mainviewmodal
    private lateinit var mainviewModal: MainviewModal
   // var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       //mainviewModal ne inisilazaion ViewModalprovider thi..
       mainviewModal = ViewModelProvider(this).get(MainviewModal::class.java)
       updatecounter()

        binding.btnPlus.setOnClickListener {
           // counter++
            mainviewModal.increment()
            updatecounter()
        }
        binding.btnMin.setOnClickListener {
           // counter--
            mainviewModal.dencrement()
            updatecounter()
        }


    }
//update for counter value
    private fun updatecounter() {
        binding.tvCounter.text = "${mainviewModal.getcounter()}"
    }
}