package com.example.app_adopter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

import com.example.app_adopter.databinding.CustomlistBinding

class CustomList(context: Context, var title: Array<String>, var des: Array<String>) :
    ArrayAdapter<String>(context, R.layout.customlist, title) {

    //    class CustomList(context: Context) : ArrayAdapter<datamodel>{
    lateinit var binding: CustomlistBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

         val layoutInflater = LayoutInflater.from(context).inflate(R.layout.customlist, null, true)
        //binding = CustomlistBinding.inflate(LayoutInflater.from(context), parent, false)

        //binding.tvTitle.text = title.get(position)
        //binding.tvDes.text = des.get(position)


        var tvtitle = layoutInflater.findViewById<TextView>(R.id.tvTitle)
        var tvDes = layoutInflater.findViewById<TextView>(R.id.tvDes)
        tvtitle.text = title.get(position)
        tvDes.text = des.get(position)
        //return super.getView(position, convertView, parent)

        return layoutInflater
    }


//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
////        var row = convertView
////
////        if (row == null) {
////            var inflater =
////                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
////            binding = CustomlistBinding.inflate(inflater, parent, false)
////            row = binding.root
////        } else {
////            binding.tvTitle.text = title.get(position)
////            binding.tvDes.text = des.get(position)
////        }
//
//
//        binding = CustomlistBinding.inflate(LayoutInflater.from(context), parent, true)
//        binding.tvTitle.text = title.get(position)
//        binding.tvDes.text = des.get(position)
//
//        return binding.root
//        //return super.getView(position, convertView, parent)
//    }


}