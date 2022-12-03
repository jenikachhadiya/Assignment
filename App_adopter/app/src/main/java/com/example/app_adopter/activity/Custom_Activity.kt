package com.example.app_adopter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_adopter.Adoptor.CustomAdoptor
import com.example.app_adopter.Modal.Custom
import com.example.app_adopter.R
import com.example.app_adopter.databinding.ActivityCustomBinding

class Custom_Activity : AppCompatActivity() {
    lateinit var binding: ActivityCustomBinding
    private var Groslist = mutableListOf<Custom>()
    lateinit var adoptor: CustomAdoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set method
        grosdata()
        //data set
        adoptor =CustomAdoptor(this,Groslist,)
        //
        binding.gridView.adapter = adoptor


    }

    private fun grosdata() {
        Groslist.add(Custom(1,"Burger",56.67f,R.drawable.burger))
        Groslist.add(Custom(2,"HotDog",46.67f,R.drawable.hotdog))
        Groslist.add(Custom(3,"Wheat",23.60f,R.drawable.wheat))
        Groslist.add(Custom(4,"Coffee",89.67f,R.drawable.coffee))
        Groslist.add(Custom(5,"CupCake",50.67f,R.drawable.cupcake))
        Groslist.add(Custom(6,"Popcorn",76.67f,R.drawable.popcorn))
        Groslist.add(Custom(7,"Smoothie",99.62f,R.drawable.smoothie))
        Groslist.add(Custom(8,"Softdrink",56.97f,R.drawable.softdrink))
        Groslist.add(Custom(9,"Greentea",76.67f,R.drawable.greentea))
        Groslist.add(Custom(10,"Popcorn",56.00f,R.drawable.popcorn))
    }
}