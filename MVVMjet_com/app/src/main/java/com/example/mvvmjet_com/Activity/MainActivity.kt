package com.example.mvvmjet_com.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpmodal_view_presenter.network.Api_Clinte
import com.example.mvvmjet_com.databinding.ActivityMainBinding
import com.example.retrofitgetmethod.Adaptor.recycle_adaptor
import com.example.retrofitgetmethod.Modal.UserResponse
import com.example.retrofitgetmethod.Modal.user
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var userlist = mutableListOf<user>()
    lateinit var UAdoptors: recycle_adaptor

    lateinit var mainviewModal: MainviewModal


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //view modal initilazation
        mainviewModal = ViewModelProvider(this).get(MainviewModal::class.java)

        //live data obcerver class
        mainviewModal.fatchuserlist.observe(this, Observer {

          UAdoptors.setItem(it as MutableList<user>)

        })

        mainviewModal.isLoding.observe( this, Observer {
            if (it)
                binding.progressbar.visibility = View.VISIBLE
            else
                binding.progressbar.visibility = View.GONE
        })

        recyclerviewdata()
    }

    private fun recyclerviewdata() {
        UAdoptors = recycle_adaptor(this, userlist)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = UAdoptors
    }




}