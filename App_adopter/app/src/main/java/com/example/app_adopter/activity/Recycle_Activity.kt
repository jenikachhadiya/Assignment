package com.example.app_adopter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.app_adopter.Adoptor.Recycle_Adoptor
import com.example.app_adopter.Modal.Recycleclass
import com.example.app_adopter.R
import com.example.app_adopter.databinding.ActivityRecycleBinding

class Recycle_Activity : AppCompatActivity() {

    lateinit var binding: ActivityRecycleBinding

    private var itemlist = mutableListOf<Recycleclass>()
    lateinit var Radapter: Recycle_Adoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //methd for add item
        dataintilazation()
        //set data to adoptor to adoptorview

        Radapter = Recycle_Adoptor(this,itemlist)


       /* var manger = GridLayoutManager(applicationContext,2,GridLayoutManager.VERTICAL,false)
        binding.recView.layoutManager = manger
*/

        var manger = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recView.layoutManager = manger

     /*   var manger = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recView.layoutManager = manger*/

        binding.recView.adapter =Radapter




    }

    private fun dataintilazation() {
        itemlist.let {
            it.add(Recycleclass(1,"Fashion",R.drawable.fashoin))
            it.add(Recycleclass(2,"Mobiles",R.drawable.mobile))
            it.add(Recycleclass(3,"Fresh",R.drawable.fresh))
            it.add(Recycleclass(4,"MiniTv",R.drawable.minitv))
            it.add(Recycleclass(5,"Deals",R.drawable.deals))
            it.add(Recycleclass(6,"Electronics",R.drawable.electronic))
            it.add(Recycleclass(7,"Home",R.drawable.home))
            it.add(Recycleclass(8,"Travel",R.drawable.train1))
            it.add(Recycleclass(9,"Book,Toys",R.drawable.book))
            it.add(Recycleclass(10,"Appliances",R.drawable.appliances))
            it.add(Recycleclass(11,"Movies",R.drawable.movies))
            it.add(Recycleclass(12,"Furnitures",R.drawable.furnicher))
            it.add(Recycleclass(13,"Beauty",R.drawable.beauty))
            it.add(Recycleclass(14,"Pharmacy",R.drawable.pharmacy))







        }









    }
}