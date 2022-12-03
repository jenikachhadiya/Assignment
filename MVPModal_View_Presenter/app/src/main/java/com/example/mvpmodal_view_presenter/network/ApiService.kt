package com.example.mvpmodal_view_presenter.network



import com.example.mvpmodal_view_presenter.network.Callback.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(value = "users?page=2")
    fun getuserlist(): Call<UserResponse>
}