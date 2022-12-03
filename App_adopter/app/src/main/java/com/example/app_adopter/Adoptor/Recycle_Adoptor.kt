package com.example.app_adopter.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_adopter.Modal.Recycleclass
import com.example.app_adopter.databinding.RecycleItemLyoutBinding

class Recycle_Adoptor(var context: Context,var itemlist:MutableList<Recycleclass>) :
    RecyclerView.Adapter<Recycle_Adoptor.innerRecycle>() {


   private lateinit var binding: RecycleItemLyoutBinding

    class innerRecycle (var bind : RecycleItemLyoutBinding):RecyclerView.ViewHolder(bind.root){




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innerRecycle {
        binding =RecycleItemLyoutBinding.inflate(LayoutInflater.from(context),parent,false)

        return innerRecycle(binding)
    }

    override fun onBindViewHolder(holder: innerRecycle, position: Int) {

        var item = itemlist[position]
        item.let {
            holder.bind.tvTitle.text = item.tital
            holder.bind.ivImg.setImageResource(item.image)
        }

        //clike event




    }

    override fun getItemCount(): Int {
        return itemlist.size
    }


}