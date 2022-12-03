package com.app.androiddependentapicalling.network.callback

import com.app.androidlocalhost.model.User

data class RegisterCallback(
    var status:String,
    var message:String,
    var user: User
)
