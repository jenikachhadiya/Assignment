package com.app.androidlocalhost.network.callback

import com.app.androidlocalhost.model.User
import com.google.gson.annotations.SerializedName

data class UserListCallback(
    @SerializedName("student")
    var userList:List<User>
)
