package com.example.onbodingscreen.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onbodingscreen.Activity.VerticalFragment
import com.example.onbodingscreen.databinding.VarticalSwipeBinding
import com.example.onbodingscreen.modal.autoscroll
import com.example.onbodingscreen.modal.vartical

/*
class OnBodingVartical(var context: Context,var vartlist:MutableList<vartical>) :PagerAdapter(){

    lateinit var binding: VarticalSwipeBinding


    override fun getCount(): Int {
        return vartlist.size

    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {


        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        binding = VarticalSwipeBinding.inflate(LayoutInflater.from(context),container,false)
        var vart = vartlist[position]
        binding.ivImg.setImageResource(vart.Img)
        binding.tvTit.text = vart.Tital
        binding.tvDe.text = vart.Des


        container.addView(binding.root)

        return  binding.root

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }
}*/




class OnBodingVarticalAdapter(
    var vartlist: MutableList<autoscroll>,
     fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    lateinit var binding: VarticalSwipeBinding

    override fun getItemCount(): Int {
      return vartlist.size
    }

    override fun createFragment(position: Int): Fragment {
        return VerticalFragment()
    }


//    override fun getCount(): Int {
//        return vartlist.size
//
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }

    /*  override fun instantiateItem(container: ViewGroup, position: Int): Any {

          binding = VarticalSwipeBinding.inflate(LayoutInflater.from(context),container,false)
          var vart = vartlist[position]
          binding.ivImg.setImageResource(vart.Img)
          binding.tvTit.text = vart.Tital
          binding.tvDe.text = vart.Des


          container.addView(binding.root)

          return  binding.root

      }

      override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

          container.removeView(`object` as View)
      }*/
}
