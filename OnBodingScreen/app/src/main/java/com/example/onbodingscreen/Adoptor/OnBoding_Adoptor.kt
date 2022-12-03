package com.example.onbodingscreen.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.onbodingscreen.databinding.ActivityOnBodingScreen2Binding
import com.example.onbodingscreen.databinding.NewLayoutBinding
import com.example.onbodingscreen.modal.item

class OnBoding_Adoptor(var context: Context,var itemlist :MutableList<item>):PagerAdapter() {

    lateinit var binding: NewLayoutBinding

    override fun getCount(): Int {
        return  itemlist.size
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {

       return  view ==`object`
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        binding = NewLayoutBinding.inflate(LayoutInflater.from(context),container,false)

        var item =itemlist[position]

        binding.ivIg.setImageResource(item.Img)
        binding.tvStp.text = item.step
        binding.tvDes.text = item.Des
        binding.tvTital.text = item.Tital

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {


        container.removeView(`object` as View)


    }
}