package com.example.getapi.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API_Clinets {

    companion object{

        private var retrofit : Retrofit? = null

        fun init():API_Service{
           if (retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl("https://covid-193.p.rapidapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
           }
            return retrofit!!.create(API_Service::class.java)
        }



    }

}