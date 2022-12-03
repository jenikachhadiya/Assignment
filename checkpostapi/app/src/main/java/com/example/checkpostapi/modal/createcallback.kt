package com.example.checkpostapi.modal

import retrofit2.Call

data class createcallback(
    var status:String,
    var message:String,
    var user:User
)
