package com.example.localhost.Interface

import com.example.localhost.Modal.student
import com.example.localhost.network.RegisterCallback
import com.example.localhost.network.UserListCallback
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("student.php")
    fun register(
        @Field("flag") flag: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile") contact: String,
        @Field("password") password: String
    ):Call<RegisterCallback>

    @GET("student.php")
    fun getUserList(@Query("flag") flag: Int) : Call<student>

    @FormUrlEncoded
    @POST("student.php")
    fun LoginUser(
        @Field("flag") flag: Int,
        @Field("email") email: String,
        @Field("password") password: String
    ):Call<RegisterCallback>


    @FormUrlEncoded
    @POST("student.php")
    fun UpdateData(
        @Field("flag") flag: Int,
        @Field("id") Id: String,
        @Field("name")  name: String,
        @Field("email") email:String,
        @Field("mobile") mobile:String
    ):Call<student>

    @FormUrlEncoded
    @POST("student.php")
    fun DeleteUser(
        @Field("flag") flag: Int,
        @Field("id") Id: String,
    ):Call<student>





}