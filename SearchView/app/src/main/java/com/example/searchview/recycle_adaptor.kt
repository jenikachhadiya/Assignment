package com.example.searchview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.searchview.databinding.RecycleItemLayoutBinding

class recycle_adaptor(var context: Context, var recyclelist:List<recycle>)
    : RecyclerView.Adapter<recycle_adaptor.innersee>() {

    lateinit var binding:RecycleItemLayoutBinding
    class innersee(var bind: RecycleItemLayoutBinding) : RecyclerView.ViewHolder(bind.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innersee {
        binding = RecycleItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return innersee(binding)

    }

    override fun onBindViewHolder(holder: innersee, position: Int) {
        var recycle = recyclelist[position]
        holder.bind.ivP3.setImageResource(recycle.Img)
        holder.bind.lacationN.text = recycle.locN
        holder.bind.rating.rating = recycle.rating
        holder.bind.resN.text = recycle.recN
        holder.bind.timeN.text = recycle.Time

        /*holder.bind.cantiner.setOnClickListener {
            listner.childClicke(it,recycle,position)
        }*/

    }

    override fun getItemCount(): Int {
        return recyclelist.size

    }
}