package com.example.androidlocalhost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.app.androidlocalhost.model.User
import com.app.androidlocalhost.network.ApiClient
import com.app.androidlocalhost.network.callback.UserListCallback
import com.example.androidlocalhost.databinding.ActivityHomeBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    var userlist = mutableListOf<User>()
    lateinit var uadaptor:ArrayAdapter<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        ApiClient.init().getUserList(4).enqueue(object:Callback<UserListCallback>{
            override fun onResponse(call: Call<UserListCallback>, response: Response<UserListCallback>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        uadaptor = ArrayAdapter(applicationContext,
                        android.R.layout.simple_list_item_1,
                        userlist)
                        binding.listView.adapter = uadaptor
                    }

                }
            }

            override fun onFailure(call: Call<UserListCallback>, t: Throwable) {

            }

        })
    }
}