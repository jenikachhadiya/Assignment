package com.example.amazon.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Modal.horizontal
import com.example.amazon.databinding.HorizontalLayoutBinding

class horzontal_Adoptor(var context: Context,var horlist:MutableList<horizontal>) :RecyclerView.Adapter<horzontal_Adoptor.myviewholder>(){
    lateinit var binding: HorizontalLayoutBinding

    class myviewholder(var bind: HorizontalLayoutBinding) :RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
    binding = HorizontalLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return myviewholder(binding)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
       var hor = horlist[position]


        holder.bind.ivImg.setImageResource(hor.Img)
        holder.bind.tvName.text = hor.Tital


        var adoptor= vartical_adoptor(context,hor.vatilist)

        binding.innerRec.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.innerRec.adapter = adoptor
    }

    override fun getItemCount(): Int {
       return horlist.size
    }

}