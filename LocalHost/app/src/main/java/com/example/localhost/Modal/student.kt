package com.example.localhost.Modal

import com.google.gson.annotations.SerializedName

data class student(
    @SerializedName("student")
    var student: MutableList<User>
)
