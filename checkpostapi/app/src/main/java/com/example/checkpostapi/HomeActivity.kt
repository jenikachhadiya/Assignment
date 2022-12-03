package com.example.checkpostapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import com.example.checkpostapi.databinding.ActivityHomeBinding
import com.example.checkpostapi.modal.User
import com.example.checkpostapi.modal.userlistcallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
     var listdata =  mutableListOf<User>()
    lateinit var lAdaptor:ArrayAdapter<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //call api

        Apiclient.Init().userlistget(4).enqueue(object : Callback<userlistcallback>{
            override fun onResponse(
                call: Call<userlistcallback>,
                response: Response<userlistcallback>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {


                        lAdaptor = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,it.studentlist)
                        binding.listItem.adapter = lAdaptor


                    }
                }
            }

            override fun onFailure(call: Call<userlistcallback>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })




    }



}