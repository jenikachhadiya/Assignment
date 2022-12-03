package com.example.mvpmodal_view_presenter.network.Callback

import com.example.mvpmodal_view_presenter.Modal.support
import com.example.mvpmodal_view_presenter.Modal.user
import com.google.gson.annotations.SerializedName

data class UserResponse(
    var page:Int,
    var par_page:Int,
    var total:Int,
    @SerializedName("total_pages")
    var totalPage:Int,
    @SerializedName("support")
    var Support: support,
    @SerializedName("data")
    var Userlist:MutableList<user>
)
