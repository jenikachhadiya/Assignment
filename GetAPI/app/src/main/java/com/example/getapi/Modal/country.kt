package com.example.getapi.Modal

import com.google.gson.annotations.SerializedName

data class country(

    @SerializedName("response")
    var response: MutableList<String>

)
