package com.example.vartical_viewpager2.Adoptor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.vartical_viewpager2.Modal.vartical_swipe

class var_swipe_Adoptor(var varlist:MutableList<vartical_swipe>,fragmentActivity: FragmentActivity)

    : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {

        return varlist.size

    }

    override fun createFragment(position: Int): Fragment {
    return var_fragment()

    }
}