package com.example.getapi.network

import com.example.getapi.Modal.country
import com.example.getapi.Modal.state
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface API_Service {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
        "X-RapidAPI-Key: 7f8863649emsh83561014cecc64cp18a6b5jsnbf69731e1170",
        "X-RapidAPI-Host: covid-193.p.rapidapi.com"
    )

    @GET(value="countries")
    // fun getcountry(@Headers("X-RapidAPI-Key") key:String, @Header("X-RapidAPI-Host") valuedata:String):Call<MutableList<country>>
    fun getcountry():Call<country>

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
        "X-RapidAPI-Key: 7f8863649emsh83561014cecc64cp18a6b5jsnbf69731e1170",
        "X-RapidAPI-Host: covid-193.p.rapidapi.com"
    )


    @GET(value="statistics")
    // fun getcountry(@Headers("X-RapidAPI-Key") key:String, @Header("X-RapidAPI-Host") valuedata:String):Call<MutableList<country>>
    fun getstate():Call<state>



}