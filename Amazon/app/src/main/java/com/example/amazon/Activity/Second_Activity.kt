package com.example.amazon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazon.Adoptors.horzontal_Adoptor
import com.example.amazon.Adoptors.vartical_adoptor
import com.example.amazon.Modal.horizontal
import com.example.amazon.Modal.vartical
import com.example.amazon.R
import com.example.amazon.databinding.ActivitySecondBinding

class Second_Activity : AppCompatActivity() {
    //parent data layout binding
    lateinit var binding: ActivitySecondBinding
    //parent data list
   private var horlist = mutableListOf<horizontal>()
    lateinit var Hadoptor :horzontal_Adoptor

    //second varticL




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()



//parent data adopror
        Hadoptor = horzontal_Adoptor(this,horlist)
        var manager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        binding.recView.layoutManager = manager
        binding.recView.adapter=Hadoptor

    }

    private fun addData() {

        var  vartilist = mutableListOf<vartical>()
        vartilist.apply {
           this.add(vartical(1, R.drawable.firstp))
            this.add( vartical(2, R.drawable.second))
            this.add(vartical(3, R.drawable.three))
            this.add(vartical(4, R.drawable.fourth))
            this.add( vartical(5, R.drawable.five))
        }


        horlist = mutableListOf()

        horlist.add(horizontal(1,"Fashion",R.drawable.fashoin,vartilist))
        horlist.add(horizontal(2,"Appliances",R.drawable.appliances,vartilist))
        horlist.add(horizontal(3,"Beauty",R.drawable.beauty,vartilist))
        horlist.add(horizontal(4,"Book",R.drawable.book,vartilist))
        horlist.add(horizontal(5,"Deals",R.drawable.deals,vartilist))
        horlist.add(horizontal(6,"Electronic",R.drawable.electronic,vartilist))
        horlist.add(horizontal(7,"Fresh",R.drawable.fresh,vartilist))
        horlist.add(horizontal(8,"Furnichers",R.drawable.furnicher,vartilist))
        horlist.add(horizontal(9,"Home",R.drawable.home,vartilist))
        horlist.add(horizontal(10,"MiniTv",R.drawable.minitv,vartilist))
        horlist.add(horizontal(11,"Mobile",R.drawable.mobile,vartilist))
        horlist.add(horizontal(12,"Movies",R.drawable.movies,vartilist))
        horlist.add(horizontal(13,"Pharmarcy",R.drawable.pharmacy,vartilist))
        horlist.add(horizontal(14,"Travel",R.drawable.train1,vartilist))






    }
}