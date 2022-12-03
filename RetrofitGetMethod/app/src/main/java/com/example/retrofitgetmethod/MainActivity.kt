package com.example.retrofitgetmethod

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitgetmethod.Adaptor.recycle_adaptor
import com.example.retrofitgetmethod.Modal.UserResponse
import com.example.retrofitgetmethod.Modal.user
import com.example.retrofitgetmethod.databinding.ActivityMainBinding
import com.example.retrofitgetmethod.httpRequest.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var retofit: Retrofit
    private var userlist = mutableListOf<user>()
    lateinit var UAdoptors: recycle_adaptor
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//api cline valo code aya che
        retofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retofit.create(ApiService::class.java)


        UAdoptors = recycle_adaptor(this, userlist)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = UAdoptors

        loadUserList()
    }

    private fun loadUserList() {
        binding.progressbar.visibility = View.VISIBLE
        var callback = apiService.getuserlist()
        callback.enqueue(object :Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                binding.progressbar.visibility = View.GONE
                //success
                if (response.isSuccessful){
                   var res = response.body()
                    res?.let{

                         userlist= it.Userlist
                         UAdoptors.setItem(userlist)


                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
               //failde
                binding.progressbar.visibility = View.GONE
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_SHORT).show()

            }

        })
    }
}