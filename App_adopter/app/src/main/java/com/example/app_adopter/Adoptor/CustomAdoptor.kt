package com.example.app_adopter.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.app_adopter.CustomList
import com.example.app_adopter.Modal.Custom
import com.example.app_adopter.databinding.ActivityCustomBinding
import com.example.app_adopter.databinding.CustomGrocBinding

class CustomAdoptor(var context: Context,var Groslist :MutableList<Custom> ):BaseAdapter() {

    lateinit var binding:CustomGrocBinding

    override fun getCount(): Int {
        return  Groslist.size

    }

    override fun getItem(pos: Int): Any {
        return  Groslist[pos]
    }

    override fun getItemId(pos: Int): Long {
        return  pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        binding = CustomGrocBinding.inflate(LayoutInflater.from(context),parent,false)

        var Custom = Groslist[pos]

        binding.ivIcon.setImageResource(Custom.image)
        binding.ivPr.text = Custom.price.toFloat().toString()
        binding.tvName.text = Custom.name


        return  binding.root






    }
}