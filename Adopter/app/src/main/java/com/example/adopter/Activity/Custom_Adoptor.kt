package com.example.adopter.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adopter.Modal.Fruit
import com.example.adopter.Adoptor.FruitAdoptor
import com.example.adopter.R
import com.example.adopter.databinding.ActivityCustomAdoptorBinding

class Custom_Adoptor : AppCompatActivity() {
    lateinit var binding: ActivityCustomAdoptorBinding
    private var Fruitlist  = mutableListOf<Fruit>()
    lateinit var adoptor: FruitAdoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomAdoptorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //method adding muteble list in
        PrepareData()

        //passing data to adopoter using constructor
        adoptor = FruitAdoptor(this,Fruitlist)
        //set adoptor
        binding.listView.adapter = adoptor

    }

    private fun PrepareData() {

        Fruitlist.add(Fruit(1,"Peru",90,2016,4.5f, R.drawable.i1))
        Fruitlist.add(Fruit(2,"Oreange",100,2014,4.0f, R.drawable.i2))
        Fruitlist.add(Fruit(3,"Watermelon",130,2012,3.5f, R.drawable.i3))
        Fruitlist.add(Fruit(4,"Greps",70,2013,4.0f, R.drawable.i4))
        Fruitlist.add(Fruit(5,"Mengo",85,2019,2.5f, R.drawable.i5))
    }
}