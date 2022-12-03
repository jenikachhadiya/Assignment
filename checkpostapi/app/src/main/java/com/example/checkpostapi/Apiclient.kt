package com.example.checkpostapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {

    companion object {
        private var retofit: Retrofit? = null

        fun Init(): ApiSer {

            if (retofit == null) {
                retofit = Retrofit.Builder()
                    .baseUrl("http://192.168.1.106/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retofit!!.create(ApiSer::class.java)

        }

    }
}