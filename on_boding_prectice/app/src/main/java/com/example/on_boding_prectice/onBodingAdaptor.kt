package com.example.on_boding_prectice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.on_boding_prectice.databinding.FragmentVerticalBinding

class onBodingAdaptor(var contex: Context, var mutList: MutableList<item>) : PagerAdapter() {

    lateinit var binding: FragmentVerticalBinding

    override fun getCount(): Int {
        return mutList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        binding = FragmentVerticalBinding.inflate(LayoutInflater.from(contex),container,false)

        var item = mutList[position]
        binding.ivIg.setImageResource(item.Img)
        binding.tvTital.text = item.Tital
        binding.tvDes.text = item.Des
        binding.tvStp.text = item.step


        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}