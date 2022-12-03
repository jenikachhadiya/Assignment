package com.example.getrequestdepandendapi

import com.example.getrequestdepandendapi.Modal.City
import com.example.getrequestdepandendapi.Modal.Country
import com.example.getrequestdepandendapi.Modal.State
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface Api_Service {

    @Headers(
        "Accept: application/json",
        "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJtZUBnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiJZN1E4dkdYbGktVmt" +
                "FTTFHVUFqNFRfYnFDNzA3cXlCbXJqUDM2VDJOLWRlOGhSWWdJb1RhODhiV2c0M0Q5MmYxMzhNIn0sImV4cCI6MTY2NT" +
                "UxMjYyNn0.GdyQrbfc0stj8T9ca2hDU33mXHuNlVT3R6sVrwW4-F4"
    )

    @GET(value = "countries")
    fun getcountry():Call<List<Country>>

    @Headers(
        "Accept: application/json",
        "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJtZUBnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiJZN1E4dkdYbGktVmt" +
                "FTTFHVUFqNFRfYnFDNzA3cXlCbXJqUDM2VDJOLWRlOGhSWWdJb1RhODhiV2c0M0Q5MmYxMzhNIn0sImV4cCI6MTY2NT" +
                "UxMjYyNn0.GdyQrbfc0stj8T9ca2hDU33mXHuNlVT3R6sVrwW4-F4"
    )

    @GET("states/{con}")
    fun getstates(@Path("con")country: String):Call<List<State>>
    @Headers(
        "Accept: application/json",
        "Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7InVzZXJfZW1haWwiOiJtZUBnbWFpbC5jb20iLCJhcGlfdG9rZW4iOiJZN1E4dkdYbGktVmt" +
                "FTTFHVUFqNFRfYnFDNzA3cXlCbXJqUDM2VDJOLWRlOGhSWWdJb1RhODhiV2c0M0Q5MmYxMzhNIn0sImV4cCI6MTY2NT" +
                "UxMjYyNn0.GdyQrbfc0stj8T9ca2hDU33mXHuNlVT3R6sVrwW4-F4"
    )

    @GET("cities/{Cit}")
    fun getcity(@Path("Cit")state: String):Call<List<City>>
}