package com.example.onbodingscreen.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.onbodingscreen.Adoptor.auto_Adoptor
//import com.example.onbodingscreen.Adoptor.OnBodingVartical
import com.example.onbodingscreen.R
import com.example.onbodingscreen.databinding.ActivityOnBodingVarticalBinding
import com.example.onbodingscreen.modal.autoscroll
import com.example.onbodingscreen.modal.vartical

class OnBodingVartical : AppCompatActivity() {
    lateinit var binding: ActivityOnBodingVarticalBinding
    //var vartilist = mutableListOf<vartical>()
  //private lateinit var Vadoptor : OnBodingVartical

      lateinit var adoptor: auto_Adoptor
      var autolist = mutableListOf<autoscroll>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityOnBodingVarticalBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // pareparData()

       // Vadoptor = OnBodingVartical(this,vartilist)

       // binding.viewPager2.adapter = Vadoptor

        addData()
        adoptor = auto_Adoptor(this,autolist)
        //binding.viewPager2.orientation=
        binding.viewPager2.adapter = adoptor
        binding.viewPager2.setCurrentItem(0,true)


    }

    private fun addData() {
        autolist.add(autoscroll(1,R.drawable.ic_launcher_foreground))
        autolist.add(autoscroll(1,R.drawable.ic_launcher_background))
        autolist.add(autoscroll(1,R.drawable.ic_launcher_foreground))
        autolist.add(autoscroll(1,R.drawable.ic_launcher_background))
        autolist.add(autoscroll(1,R.drawable.ic_launcher_background))
        autolist.add(autoscroll(1,R.drawable.img))
    }
/*
    private fun pareparData() {

        vartilist.add(vartical(1,"Choose your Foods",R.drawable.fir,"This Handly Tool Helps You Create Dummay Text  for All Your Layout Needs "))
        vartilist.add(vartical(2,"Choose your Foods",R.drawable.img,"This Handly Tool Helps You Create Dummay Text  for All Your Layout Needs "))
        vartilist.add(vartical(3,"Choose your Foods",R.drawable.fir,"This Handly Tool Helps You Create Dummay Text  for All Your Layout Needs "))
        vartilist.add(vartical(4,"Choose your Foods",R.drawable.img,"This Handly Tool Helps You Create Dummay Text  for All Your Layout Needs "))
    }*/
}