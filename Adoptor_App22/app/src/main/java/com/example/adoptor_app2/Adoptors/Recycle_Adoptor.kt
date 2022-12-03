package com.example.adoptor_app2.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptor_app2.Classes.OnClickevent
import com.example.adoptor_app2.Classes.Recycleclass
import com.example.adoptor_app2.databinding.ActivityRecycleBinding
import com.example.adoptor_app2.databinding.RecycleItemLayoutBinding

class Recycle_Adoptor(var context: Context,var Reclist:MutableList<Recycleclass>):RecyclerView.Adapter<Recycle_Adoptor.innerRec>(){

    lateinit var binding: RecycleItemLayoutBinding
    private lateinit var Reclickevnt:OnClickevent


    class  innerRec(var bind: RecycleItemLayoutBinding):RecyclerView.ViewHolder(bind.root){

    }
    fun SetRecClicke(recevent:OnClickevent){
        this.Reclickevnt = recevent
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): innerRec {
        binding = RecycleItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return  innerRec(binding)
    }

    override fun onBindViewHolder(holder: innerRec, position: Int) {

        var item = Reclist[position]
        holder.bind.tvTital.text = item.Tital
        holder.bind.tvPr.text = "${item.price}"
        holder.bind.ivIcon.setImageResource(item.Img)
        holder.bind.rbRat.rating =item.rating


//        holder.bind.linear.setOnClickListener {
//            Clicke_Event.OnItemClick(item.id,position,item.Tital)
//        }

        holder.bind.recyCus.setOnClickListener {
            Reclickevnt.RecClick(item ,position)

        }



    }

    override fun getItemCount(): Int {
        return Reclist.size
    }


}