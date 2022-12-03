package com.example.adop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adop.databinding.RecycleLayoutBinding

class Adoptor(var context: Context,var itemlist:MutableList<item>)
    :RecyclerView.Adapter<Adoptor.innerAdp>(){
    private lateinit var binding: RecycleLayoutBinding


    class innerAdp(var bind: RecycleLayoutBinding) :RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innerAdp {
        binding = RecycleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return innerAdp(binding)
    }

    override fun onBindViewHolder(holder: innerAdp, position: Int) {
        var item = itemlist[position]
        holder.bind.ivImg.setImageResource(item.img)
        holder.bind.tvTital.text = item.name
        holder.bind.rbRat.rating = item.rating
        holder.bind.tvPr.text ="${item.price}"
    }

    override fun getItemCount(): Int {
      return itemlist.size
    }

}