package com.example.retrofitgetmethod.httpRequest


import com.example.retrofitgetmethod.Modal.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(value = "users?page=2")
    fun getuserlist(): Call<UserResponse>
}