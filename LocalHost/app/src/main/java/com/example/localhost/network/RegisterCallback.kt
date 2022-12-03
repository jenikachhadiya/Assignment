package com.example.localhost.network

import com.example.localhost.Modal.User

data class RegisterCallback(
    var status:String,
    var message:String,
    var user: User
)
