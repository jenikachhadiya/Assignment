package com.example.checkpostapi.modal

import retrofit2.Call

data class User(
    var id:Int,
    var name:String,
    var email:String,
    var mobile:String,
    var password:String
)