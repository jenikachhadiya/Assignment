package com.example.adopter.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.adopter.Modal.Fruit
import com.example.adopter.databinding.ItemLayoutBinding

class FruitAdoptor(var context: Context,var Fruitlist:MutableList<Fruit>) :BaseAdapter() {

    private  lateinit var binding :ItemLayoutBinding

    override fun getCount(): Int {
        return Fruitlist.size
    }

    override fun getItem(pos: Int): Any {

        return Fruitlist[pos]
    }

    override fun getItemId(pos: Int): Long {
       return  pos.toLong()
    }

    override fun getView(pos: Int, view: View?, p2: ViewGroup?): View {

        binding = ItemLayoutBinding.inflate(LayoutInflater.from(context),p2,false)

        var fruit: Fruit = Fruitlist[pos]
        binding.tvText.text = fruit.name
        binding.tvPrice.text ="${fruit.price}"
        binding.rbRating.rating = fruit.rating
        binding.tvYear.text ="${fruit.year}"
        binding.ivParu.setImageResource(fruit.image)

        return binding.root
    }
}