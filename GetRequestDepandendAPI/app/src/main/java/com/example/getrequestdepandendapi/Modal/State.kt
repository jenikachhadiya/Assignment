package com.example.getrequestdepandendapi.Modal

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("state_name")
    var stateName:String
){
    override fun toString(): String {
        return stateName
    }
}
