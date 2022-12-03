package com.example.vartical_viewpager2.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vartical_viewpager2.Modal.vartical_swipe
import com.example.vartical_viewpager2.databinding.ActivityVarticalSwipeBinding
import com.example.vartical_viewpager2.databinding.VarticalLayoutBinding

class vartical_adoptor(var context: Context,var varlist:MutableList<vartical_swipe>)
    :RecyclerView.Adapter<vartical_adoptor.myAview>(){

    lateinit var binding:VarticalLayoutBinding

    class myAview(var bind:VarticalLayoutBinding ) :RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vartical_adoptor.myAview {
       binding = VarticalLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return myAview(binding)
    }

    override fun onBindViewHolder(holder: vartical_adoptor.myAview, position: Int) {

    var vartical = varlist[position]

    holder.bind.imgView.setImageResource(vartical.img)

    }

    override fun getItemCount(): Int {
       return varlist.size
    }
}
