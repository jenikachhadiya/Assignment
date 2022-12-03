package com.example.getrequestdepandendapi.Modal

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("city_name")
    var cName :String
){
    override fun toString(): String {
        return cName
    }
}
