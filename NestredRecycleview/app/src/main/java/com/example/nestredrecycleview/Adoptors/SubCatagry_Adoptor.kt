package com.example.nestredrecycleview.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestredrecycleview.Modal.Categary
import com.example.nestredrecycleview.Modal.SubCategary
import com.example.nestredrecycleview.databinding.ItemLayoutBinding
import com.example.nestredrecycleview.databinding.TitalLayoutBinding

//child adoptor
class SubCatagry_Adoptor(var context: Context,var Subcatgrylist:MutableList<SubCategary>
,var listner: Nestred_Adoptor.ItemonClickListner)
    :RecyclerView.Adapter<SubCatagry_Adoptor.MyviewHolder>(){


    //item layout
    lateinit var binding: ItemLayoutBinding

    class MyviewHolder(var bind: ItemLayoutBinding) :RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyviewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        //data geting
        var scat = Subcatgrylist[position]
        holder.bind.ivMovie.setImageResource(scat.Img)
        holder.bind.tvTital.text = scat.Name

        holder.bind.cardparent.setOnClickListener {
            listner.childclick(it,scat)

        }


    }


    override fun getItemCount(): Int {
        return Subcatgrylist.size
    }




}