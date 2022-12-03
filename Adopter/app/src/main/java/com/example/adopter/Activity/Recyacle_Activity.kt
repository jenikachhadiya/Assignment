package com.example.adopter.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.example.adopter.Adoptor.RecycleAdoptor
import com.example.adopter.Modal.ItemRecycle
import com.example.adopter.Modal.OnItemClickLitener
import com.example.adopter.R
import com.example.adopter.databinding.ActivityRecyacleBinding

class Recyacle_Activity : AppCompatActivity() {

   private  lateinit var binding: ActivityRecyacleBinding

    //second step
   private var Recycle = mutableListOf<ItemRecycle>()
    //Forth step
   private lateinit var Radoptor: RecycleAdoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityRecyacleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //second step 2.1
        //add data in this method
        addingdata()

        //Five step
        //passing data to adoptor
        Radoptor= RecycleAdoptor(this,Recycle)

        //adoptor 13 layout Maneger
        //LinerLayout horizontal and varticali set kareva mete
        var Maneger = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false) //defalt vartical hoy che
        binding.recView.layoutManager = Maneger //set layoutmaneger in view


        //set adoptor to adoptor view
        //adoptor 12 set adopotor
        binding.recView.adapter = Radoptor

        //navigraton one activity to second activity data


        //clicke event
        //two type of click events
        //1.Adoptor class in click event
        //2.using interface

        //2.using interface
        //5.cannect to adoptor and pass object uisng pramiter
        //6.alr+enter import method
        Radoptor.setonItemclickListner(object :OnItemClickLitener{
            override fun OnCardClick(Item: ItemRecycle, pos: Int) {



            }

            override fun OnImageClick(Item: ItemRecycle) {

            }


        })







    }

    private fun addingdata() {
        Recycle.add(ItemRecycle(1,"Burger",56.67f,R.drawable.burger))
        Recycle.add(ItemRecycle(2,"HotDog",46.67f,R.drawable.hotdog))
        Recycle.add(ItemRecycle(3,"Wheat",23.60f,R.drawable.wheat))
        Recycle.add(ItemRecycle(4,"Coffee",89.67f,R.drawable.coffee))
        Recycle.add(ItemRecycle(5,"CupCake",50.67f,R.drawable.cupcake))
        Recycle.add(ItemRecycle(6,"Popcorn",76.67f,R.drawable.popcorn))
        Recycle.add(ItemRecycle(7,"Smoothie",99.62f,R.drawable.smoothie))
        Recycle.add(ItemRecycle(8,"Softdrink",56.97f,R.drawable.softdrink))
        Recycle.add(ItemRecycle(9,"Greentea",76.67f,R.drawable.greentea))
        Recycle.add(ItemRecycle(10,"Popcorn",56.00f,R.drawable.popcorn))
        Recycle.add(ItemRecycle(11,"Burger",56.67f,R.drawable.burger))
        Recycle.add(ItemRecycle(12,"HotDog",46.67f,R.drawable.hotdog))
        Recycle.add(ItemRecycle(13,"Wheat",23.60f,R.drawable.wheat))
        Recycle.add(ItemRecycle(14,"Coffee",89.67f,R.drawable.coffee))
        Recycle.add(ItemRecycle(15,"CupCake",50.67f,R.drawable.cupcake))

    }
}