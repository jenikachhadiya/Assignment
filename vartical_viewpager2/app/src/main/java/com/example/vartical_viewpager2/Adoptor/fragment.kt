package com.example.vartical_viewpager2.Adoptor

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vartical_viewpager2.R
import androidx.fragment.app.Fragment as Fragment1

class var_fragment() : Fragment1(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vartical_layout, container, false)
    }

}
