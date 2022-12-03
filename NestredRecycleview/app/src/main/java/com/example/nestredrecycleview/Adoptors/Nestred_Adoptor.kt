package com.example.nestredrecycleview.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestredrecycleview.Modal.Categary
import com.example.nestredrecycleview.Modal.SubCategary
import com.example.nestredrecycleview.databinding.TitalLayoutBinding

//parent adoptor
class Nestred_Adoptor(var context: Context,var movielist:MutableList<Categary>)
    :RecyclerView.Adapter<Nestred_Adoptor.MyviewHolder>(){


    //parent layot binding
    lateinit var binding: TitalLayoutBinding
    lateinit var listner:ItemonClickListner

    interface ItemonClickListner{

        fun ViewClick(id:Int,position: Int,tital:String)
        fun childclick(view:View,subCategary: SubCategary)

    }

    fun SetOnClickListner(listner: ItemonClickListner){
        this.listner = listner
    }

    //view holder
    class MyviewHolder(var bind: TitalLayoutBinding) :RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

      binding = TitalLayoutBinding.inflate(LayoutInflater.from(context),parent,false)

        return MyviewHolder(binding)

    }

    //data get karva mate
    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        //parent data get
     var categary = movielist[position]
        holder.bind.tvTital.text = categary.Tital

       //child adoptor maneger
        var adoptor = SubCatagry_Adoptor(context,categary.Movielist,listner)

        binding.childRecview.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.childRecview.adapter = adoptor

        holder.bind.btnViewall.setOnClickListener{
            listner.ViewClick(categary.id,position,categary.Tital)

        }


    }

    override fun getItemCount(): Int {
        return movielist.size
    }


}