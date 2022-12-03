package com.example.getmethoddependncy.Modal

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country_name")
    var CName:String,
    @SerializedName("country_short_name")
    var CSName:String,
    @SerializedName("country_phone_code")
    var Code:Int
){
    override fun toString(): String {
        return CName
    }
}
