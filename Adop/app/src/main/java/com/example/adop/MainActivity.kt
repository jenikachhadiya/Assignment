package com.example.adop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
   private  var itemlist = mutableListOf<item>()
    private  lateinit var radoptor :Adoptor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //data set
        dataset()

       radoptor = Adoptor(this,itemlist)

        var manger = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
         binding.recView.layoutManager = manger

        binding.recView.adapter = radoptor





    }

    private fun dataset() {
        itemlist.add(item(1,"Hotdog",56.67f,3.5f,R.drawable.hotdog))
        itemlist.add(item(2,"Burger",78.9f,2.1f,R.drawable.burger))
        itemlist.add(item(3,"Coffee",23.89f,4.1f,R.drawable.coffee))
        itemlist.add(item(4,"greentea",89.90f,4.7f,R.drawable.greentea))
        itemlist.add(item(5,"Popcorn",34.90f,4.5f,R.drawable.popcorn))
        itemlist.add(item(6,"Softdrink",90.89f,1.3f,R.drawable.softdrink))
        itemlist.add(item(7,"Smoothie",123.67f,4.1f,R.drawable.smoothie))
        itemlist.add(item(8,"Wheat",67.90f,3.2f,R.drawable.wheat))
    }
}