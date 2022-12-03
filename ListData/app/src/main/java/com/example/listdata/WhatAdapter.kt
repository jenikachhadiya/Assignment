package com.example.listdata

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listdata.databinding.ItemRowBinding

class WhatAdapter(var context: Context,var listdata:MutableList<Modelitem>):RecyclerView.Adapter<WhatAdapter.ViewData>() {

    lateinit var binding:ItemRowBinding

    class ViewData(var dataItem:ItemRowBinding):RecyclerView.ViewHolder(dataItem.root){
       // var bind=dataItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
       binding=ItemRowBinding.inflate(LayoutInflater.from(context),parent,false)
       return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
       var list=listdata.get(position)

       holder.dataItem.tvName.text=list.name
       holder.dataItem.ivBg.setImageResource(list.img)
       holder.dataItem.tvMess.text=list.mass
       //holder.dataItem.rbRat.rating=list.rating
       holder.dataItem.tvTime.text=list.time

    }

    override fun getItemCount(): Int {
      return listdata.size
    }
}