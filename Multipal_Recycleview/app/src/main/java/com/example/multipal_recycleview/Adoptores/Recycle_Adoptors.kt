package com.example.multipal_recycleview.Adoptores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipal_recycleview.ClickEvent.OnItemClick
import com.example.multipal_recycleview.Modal.Recycle
import com.example.multipal_recycleview.databinding.RecycleLayoutBinding

class Recycle_Adoptors(var context: Context,var recyclelist :MutableList<Recycle>):RecyclerView.Adapter<Recycle_Adoptors.myviewholder>() {
    private  lateinit var binding: RecycleLayoutBinding

     private lateinit var Clickcard :OnItemClick

     class myviewholder(var bind: RecycleLayoutBinding) :RecyclerView.ViewHolder(bind.root){


    }
    fun SetonClick(clickevent :OnItemClick)
    {
        this.Clickcard = clickevent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        binding= RecycleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return myviewholder(binding)

    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {

        var rec = recyclelist[position]
        holder.bind.ivIcon.setImageResource(rec.Img)
        holder.bind.tvTital.text = rec.Tital
        holder.bind.tvPr.text = rec.price
        holder.bind.rbRat.rating = rec.rating

        holder.bind.linear.setOnClickListener {
            Clickcard.onCardClick(rec,position)
        }

       /* holder.bind.ivIcon.setOnClickListener {
            Clickcard.onCardClick(rec)

        }
*/
    }

    override fun getItemCount(): Int {
       return recyclelist.size
    }
}