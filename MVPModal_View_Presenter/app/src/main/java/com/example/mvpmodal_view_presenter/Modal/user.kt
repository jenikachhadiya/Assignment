package com.example.mvpmodal_view_presenter.Modal

import com.google.gson.annotations.SerializedName

data class user(
    var id:Int,
    var email:String,
    @SerializedName("first_name")
    var fname:String,
    @SerializedName("last_name")
    var lname:String,
    @SerializedName("avatar")
    var imageuri:String
)
