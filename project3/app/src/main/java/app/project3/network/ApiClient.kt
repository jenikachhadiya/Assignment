package app.project3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        private var retrofit: Retrofit?=null
        private var api_url : String = "http://192.168.1.106/api/"

        //lateinit var service: ApiService

//        fun init():ApiService{
//
//            if(retrofit==null){
//                retrofit = Retrofit.Builder()
//                    .baseUrl("https://reqres.in/api/")
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//
//            return retrofit!!.create(ApiService::class.java)
//        }


        fun init():ApiService{

            if(retrofit==null){
                retrofit = Retrofit.Builder()
                    .baseUrl(api_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(ApiService::class.java)
        }

    }

}