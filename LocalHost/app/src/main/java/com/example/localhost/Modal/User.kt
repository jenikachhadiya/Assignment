package com.example.localhost.Modal

import com.google.gson.annotations.SerializedName

data class User(
    var id:String,
    var name:String,
    var email:String,
    @SerializedName("mobile")
    var contact:String,
    var password:String
)
