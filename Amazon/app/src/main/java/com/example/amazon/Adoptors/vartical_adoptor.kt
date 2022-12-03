package com.example.amazon.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Modal.vartical
import com.example.amazon.databinding.AutoSliderBinding

class vartical_adoptor (var context: Context, var autoslider :MutableList<vartical>)
    :RecyclerView.Adapter<vartical_adoptor.MyViewHolder>() {


        lateinit var binding: AutoSliderBinding

        class MyViewHolder(var bind: AutoSliderBinding) : RecyclerView.ViewHolder(bind.root){

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
            binding = AutoSliderBinding.inflate(LayoutInflater.from(context),parent,false)
            return MyViewHolder(binding)
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            var auto = autoslider[position]
            holder.bind.ivIg.setImageResource(auto.img)

       }



        override fun getItemCount(): Int {
            return  autoslider.size
        }


    /*  fun getListSize() {
          autoslider.size
      }*/


}