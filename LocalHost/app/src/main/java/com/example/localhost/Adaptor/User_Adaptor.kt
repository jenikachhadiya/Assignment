package com.example.localhost.Adaptor

import android.content.Context
import android.view.*
import android.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.localhost.Interface.InterfaceClicke
import com.example.localhost.Modal.User
import com.example.localhost.R
import com.example.localhost.databinding.RecyclerListLayoutBinding

class User_Adaptor(var context: Context, var userData: MutableList<User>) :
    RecyclerView.Adapter<User_Adaptor.ViewData>() {


    lateinit var binding: RecyclerListLayoutBinding
    lateinit var clickeevent: InterfaceClicke

    class ViewData(var itemData: RecyclerListLayoutBinding) :
        RecyclerView.ViewHolder(itemData.root) {

    }

    fun Clickelistenr(clicke: InterfaceClicke) {
        this.Clickelistenr(clicke)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        binding = RecyclerListLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var listdata = userData[position]

        holder.itemData.tvName.text = listdata.name
        holder.itemData.tvEmail.text = listdata.email
        holder.itemData.tvContect.text = listdata.contact
        holder.itemData.tvPassword.text = listdata.password

        holder.itemData.ivSelection.setOnClickListener {

            showpopmenu(position, listdata, it, clickeevent)
        }


    }

    private fun showpopmenu(
        position: Int,
        listdata: User,
        view: View?,
        clickeevent: InterfaceClicke
    ) {

        var popupMenu = PopupMenu(context, view)
        var inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu, popupMenu.menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener(
            object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(p0: MenuItem?): Boolean {
                    return when (p0?.itemId) {
                        R.id.update -> {
                            clickeevent.updatadata(position, listdata)
                            return true
                        }
                        R.id.delate -> {
                            clickeevent.delatedata(listdata)
                            return true
                        }
                        else -> {
                            return false
                        }
                    }
                }

            })


    }


    override fun getItemCount(): Int {
        return userData.size
    }

    fun setItem(arraydata: MutableList<User>) {
        this.userData = arraydata
        notifyDataSetChanged()
    }

    fun updatedata(position: Int, user: User) {

        userData[position] = user
        notifyItemChanged(position)

    }

    fun delete(user: User) {
        userData.remove(user)
        notifyDataSetChanged()
    }


}


