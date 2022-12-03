package com.example.getmethoddependncy.Modal

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("state_name")
    var SName:String
){
    override fun toString(): String {
        return SName
    }
}
