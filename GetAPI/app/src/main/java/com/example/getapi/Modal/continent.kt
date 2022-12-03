package com.example.getapi.Modal

import com.google.gson.annotations.SerializedName

data class continent(
    @SerializedName("continent")
    var con : String
){
    override fun toString(): String {
        return con
    }
}
