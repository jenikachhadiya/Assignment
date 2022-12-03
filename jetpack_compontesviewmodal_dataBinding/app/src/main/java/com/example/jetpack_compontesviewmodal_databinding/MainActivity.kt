package com.example.jetpack_compontesviewmodal_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack_compontesviewmodal_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mainviewModal: MainviewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
       // setContentView(binding.root)

        //initiation mainviewModal
        mainviewModal = ViewModelProvider(this,mainViewModalFactory(10)).get(MainviewModal::class.java)
       binding.viewmodal = mainviewModal
        binding.lifecycleOwner = this


        /*mainviewModal.counterlivedata.observe(this, Observer {
            binding.tvCounter.text = "$it"
        })*/

       // updatecounter()

      /*  binding.btnPlus.setOnClickListener {
            // counter++
            mainviewModal.increments()
          //  updatecounter()

        }*/
        /*binding.btnMin.setOnClickListener {
            //  counter--
            mainviewModal.decrements()
          //  updatecounter()
        }
*/

    }
/*
    private fun updatecounter() {
        binding.tvCounter.text = "${mainviewModal.getcounter()}"
    }*/
}