package com.example.post_localhost.interfacee


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClint {

    companion object {

        private var retofit: Retrofit? = null

        fun Init(): ApiService {

            if (retofit == null) {
                retofit = Retrofit.Builder()
                    .baseUrl("http://192.168.1.106/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retofit!!.create(ApiService::class.java)

        }
    }


}