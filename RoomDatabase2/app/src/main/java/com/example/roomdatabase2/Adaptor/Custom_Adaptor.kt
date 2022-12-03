package com.example.roomdatabase2.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase2.databinding.CustomLayoutBinding
import com.example.roomdatabase2.entity.Customer
//sep3 craete adaptor
class Custom_Adaptor (var context: Context, var customlist: MutableList<Customer>) :
    RecyclerView.Adapter<Custom_Adaptor.MyViewHolder>(){


    //create adoptor and inherit view holder
        private lateinit var binding:CustomLayoutBinding
        lateinit var onClickListener:OnListItemClickListener

        //clicke event listner
        interface OnListItemClickListener{
            fun onDeleteItemClicked(customer: Customer)
            fun onUpdateItemClicked(customer: Customer)
        }

        //clicke listner
        fun setOnListItemClickListener(onClickListener: OnListItemClickListener){
            this.onClickListener = onClickListener
        }
        class MyViewHolder(var bind: CustomLayoutBinding) : RecyclerView.ViewHolder(bind.root) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            binding = CustomLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
            return MyViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            //set data in user class
            var customer = customlist[position]

            holder.bind.tvId.text = "${customer.id}"
            holder.bind.tvName.text = "${customer.Name}"
            holder.bind.tvEmail.text = "${customer.Email}"

            //delete nu clicke event
            holder.bind.ivDelete.setOnClickListener {
                onClickListener.onDeleteItemClicked(customer)
            }
            //edit nu cliceke event
            holder.bind.ivEdit.setOnClickListener{
                onClickListener.onUpdateItemClicked(customer)
            }

        }

        override fun getItemCount():Int {
            return customlist.size
        }

        //set data and refresh adaptor
        fun setItems(customlist:MutableList<Customer>)
        {
            this.customlist = customlist
            notifyDataSetChanged()      // refresh recyclerview with
        }

    }

