package com.example.roomdatabase.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.ItemLayoutBinding
import com.example.roomdatabase.entity.User

//create adoptor and inherit view hoder
class RecyclerUserAdapter(var context: Context, var userList: MutableList<User>) :
    RecyclerView.Adapter<RecyclerUserAdapter.MyViewHolder>() {

    private lateinit var binding: ItemLayoutBinding
    lateinit var onClickListener:OnListItemClickListener

    //clicke event listner
    interface OnListItemClickListener{
        fun onDeleteItemClicked(user:User)
        fun onUpdateItemClicked(user:User)
    }

    //clicke listner
    fun setOnListItemClickListener(onClickListener: OnListItemClickListener){
        this.onClickListener = onClickListener
    }

    class MyViewHolder(var bind: ItemLayoutBinding) : RecyclerView.ViewHolder(bind.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //set data in user class
        var user = userList[position]

        holder.bind.tvId.text = "${user.id}"
        holder.bind.tvName.text = "${user.name}"
        holder.bind.tvEmail.text = "${user.email}"

        //delete nu clicke event
        holder.bind.ivDelete.setOnClickListener {
            onClickListener.onDeleteItemClicked(user)
        }

        //edit nu cliceke event
        holder.bind.ivEdit.setOnClickListener{
            onClickListener.onUpdateItemClicked(user)
        }

    }

    override fun getItemCount():Int {
        return userList.size
    }
    //set data and refresh adaptor
    fun setItems(userList:MutableList<User>)
    {
        this.userList = userList
         notifyDataSetChanged()      // refresh recyclerview with
    }

}