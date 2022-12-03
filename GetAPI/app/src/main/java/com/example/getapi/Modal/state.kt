package com.example.getapi.Modal

import com.google.gson.annotations.SerializedName

data class state(
    @SerializedName("response")
    var res:MutableList<continent>
)
