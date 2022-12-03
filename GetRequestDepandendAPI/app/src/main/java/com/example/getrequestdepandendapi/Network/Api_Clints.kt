package com.example.getrequestdepandendapi.Network

import com.example.getrequestdepandendapi.Api_Service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api_Clints {

    companion object {
        private var retofit: Retrofit? = null

        fun init():Api_Service{
            if (retofit==null) {
                retofit = Retrofit.Builder()
                    .baseUrl("https://www.universal-tutorial.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retofit!!.create(Api_Service::class.java)

        }
    }
}