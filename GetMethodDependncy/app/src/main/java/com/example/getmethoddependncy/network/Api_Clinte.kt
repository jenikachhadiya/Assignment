package com.example.getmethoddependncy.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api_Clinte {

    companion object {

        private var retrofit: Retrofit? = null

        fun init(): API_Service {

            if (retrofit == null) {
             retrofit = Retrofit.Builder()
                    .baseUrl("https://www.universal-tutorial.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(API_Service::class.java)

        }


    }

}