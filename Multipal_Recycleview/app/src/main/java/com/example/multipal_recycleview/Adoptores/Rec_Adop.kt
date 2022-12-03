package com.example.multipal_recycleview.Adoptores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipal_recycleview.ClickEvent.OnRecClicke
import com.example.multipal_recycleview.Modal.Item
import com.example.multipal_recycleview.databinding.ItemLayoutBinding

class Rec_Adop(var context: Context,var Itemlist:MutableList<Item>)
    :RecyclerView.Adapter<Rec_Adop.innerrec>(){
    private lateinit var binding: ItemLayoutBinding

   private lateinit  var Itemclick :OnRecClicke

        class innerrec(var bind: ItemLayoutBinding) :RecyclerView.ViewHolder(bind.root){

        }

    fun Itemclikeevent( itemevent:OnRecClicke){
        this.Itemclick = itemevent

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innerrec {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return innerrec(binding)

    }

    override fun onBindViewHolder(holder: innerrec, position: Int) {

        var item = Itemlist[position]
        holder.bind.ivIg.setImageResource(item.ig)
        holder.bind.rbRat.rating = item.rating
        holder.bind.tvMess.text = item.mess
        holder.bind.tvName.text = item.name
        holder.bind.tvTime.text =item.timedText

        holder.bind.linear2.setOnClickListener {
            Itemclick.onviewclicke(item,position)

        }


    }

    override fun getItemCount(): Int {
        return Itemlist.size
    }

}