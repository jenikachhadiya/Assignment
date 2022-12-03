package com.example.listdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listdata.databinding.ActivityMainBinding
import com.example.listdata.databinding.ActivityWhatsAppBinding

class WhatsAppActivity : AppCompatActivity() {

    lateinit var binding:ActivityWhatsAppBinding
    lateinit var adapter:WhatAdapter
     var listdata= mutableListOf<Modelitem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWhatsAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_whats_app)
        init()
    }

    fun init(){
        addData()
        adapter= WhatAdapter(this,listdata)
        binding.rvList.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvList.adapter=adapter

    }

    fun addData(){

       listdata.add(Modelitem(1,"fashion",R.drawable.ic_launcher_background,"hello","10.5am"))
       listdata.add(Modelitem(2,"fashion",R.drawable.ic_launcher_background,"hello","10.5am"))
       listdata.add(Modelitem(3,"fashion",R.drawable.ic_launcher_background,"hello","10.5am"))
       listdata.add(Modelitem(4,"fashion",R.drawable.ic_launcher_background,"hello","10.5am"))
       listdata.add(Modelitem(5,"fashion",R.drawable.ic_launcher_background,"hello","10.5am"))

    }

}
