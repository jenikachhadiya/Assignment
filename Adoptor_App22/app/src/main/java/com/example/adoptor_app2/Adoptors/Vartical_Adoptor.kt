package com.example.adoptor_app2.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptor_app2.Classes.OnClickevent
import com.example.adoptor_app2.Classes.Vartical
import com.example.adoptor_app2.databinding.RecycleItemLayoutBinding
import com.example.adoptor_app2.databinding.VarticalLayoutBinding

class Vartical_Adoptor(var context: Context,var Itemlist:MutableList<Vartical>) :RecyclerView.Adapter<Vartical_Adoptor.invartical>(){


  private  lateinit var binding: VarticalLayoutBinding

  private lateinit var Varclick:OnClickevent


    class  invartical(var bind: VarticalLayoutBinding) :RecyclerView.ViewHolder(bind.root) {

    }
  fun VarClickEvent(Varevent:OnClickevent){
      this.Varclick = Varevent
  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): invartical {
        binding = VarticalLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return invartical(binding)

    }

    override fun onBindViewHolder(holder: invartical, position: Int) {
      var vart = Itemlist[position]
      holder.bind.let {

        it.ivIg.setImageResource(vart.ig)
        it.tvName.text = vart.name
        it.rbRat.rating =vart.rating
        it.tvMess.text =vart.mess
        it.tvTime.text =vart.timedText



      }
      holder.bind.varti.setOnClickListener {
        Varclick.VarClick(vart,position)


      }



    }

    override fun getItemCount(): Int {
      return Itemlist.size

    }

}