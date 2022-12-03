package com.example.mvpmodal_view_presenter.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api_Clinte {

    companion object{
        private  var retofit:Retrofit? = null

        fun init():ApiService{

            if (retofit==null){

                retofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return  retofit!!.create(ApiService::class.java)
        }
    }

}