package com.example.checkpostapi.modal

import com.google.gson.annotations.SerializedName

data class userlistcallback(
    @SerializedName("student")
    var studentlist : List<User>
)
