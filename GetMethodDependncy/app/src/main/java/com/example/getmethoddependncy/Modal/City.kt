package com.example.getmethoddependncy.Modal

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("city_name")
    var CName:String
){
    override fun toString(): String {
        return CName
    }
}
