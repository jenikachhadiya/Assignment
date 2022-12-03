package com.example.auto_imgslider.Adoptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import com.example.auto_imgslider.Modal.img
import com.example.auto_imgslider.R
import com.example.auto_imgslider.databinding.ImgLayoutBinding
import java.util.*

class auto_slider_adoptor(var context: Context,var imglist:MutableList<img>) :PagerAdapter(){

    lateinit var binding: ImgLayoutBinding

    override fun getCount(): Int {
      return imglist.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        binding = ImgLayoutBinding.inflate(LayoutInflater.from(context),container,false)

        var img = imglist[position]
        binding.imgView.setImageResource(img.Img)

        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)

    }
}