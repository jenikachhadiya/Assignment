package com.example.localhost.network

import com.example.localhost.Modal.User
import com.google.gson.annotations.SerializedName

data class UserListCallback(
    @SerializedName("student")
    var userList:List<User>
)
