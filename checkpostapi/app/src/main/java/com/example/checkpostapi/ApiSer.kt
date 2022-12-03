package com.example.checkpostapi

import com.example.checkpostapi.modal.createcallback
import com.example.checkpostapi.modal.userlistcallback
import retrofit2.Call
import retrofit2.http.*

interface ApiSer {

    @FormUrlEncoded
    @POST("student.php")
    fun createacc(
        @Field("flag") flag: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile") mobile: String,
        @Field("password") contect: String
    ):Call<createcallback>

    @GET("student.php")
    fun userlistget(@Query("flag") flag: Int):Call<userlistcallback>


}