package com.example.retrofitgetmethod.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitgetmethod.Modal.user
import com.example.retrofitgetmethod.R
import com.example.retrofitgetmethod.databinding.UserLayoutBinding

class recycle_adaptor(var context: Context, var Itemlist:MutableList<user>)
    : RecyclerView.Adapter<recycle_adaptor.innerrec>(){

        private lateinit var binding: UserLayoutBinding


        class innerrec(var bind: UserLayoutBinding) : RecyclerView.ViewHolder(bind.root)
        {


        }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innerrec {
            binding = UserLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
            return innerrec(binding)

        }

        override fun onBindViewHolder(holder: innerrec, position: Int) {

            var item = Itemlist[position]
            holder.bind.tvName.text = "${item.fname} ${item.lname}"
            holder.bind.tvEmail.text = "${item.email}"

            Glide
                .with(context)
                .load(item.imageuri)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_sync_24)
                .into(holder.bind.ivIg);



        }

        override fun getItemCount(): Int {
            return Itemlist.size
        }
    fun setItem(Itemlist: MutableList<user>){
        this.Itemlist = Itemlist
        notifyDataSetChanged()
    }

    }

