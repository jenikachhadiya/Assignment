package com.app.androidlocalhost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.app.androidlocalhost.databinding.ActivityHomeBinding
import com.app.androidlocalhost.model.User
import com.app.androidlocalhost.network.ApiClient
import com.app.androidlocalhost.network.callback.UserListCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    var userList = mutableListOf<User>()
    lateinit var mAdapter:ArrayAdapter<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiClient.init().getUserList(4).enqueue(object : Callback<UserListCallback> {
            override fun onResponse(
                call: Call<UserListCallback>,
                response: Response<UserListCallback>
            ) {

                if(response.isSuccessful){

                    response.body()?.let {
                        mAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, it.userList)
                        binding.listView.adapter = mAdapter
                    }
                }

            }

            override fun onFailure(call: Call<UserListCallback>, t: Throwable) {

            }

        })

    }
}