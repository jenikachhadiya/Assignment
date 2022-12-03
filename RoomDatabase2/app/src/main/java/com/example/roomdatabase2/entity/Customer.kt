package com.example.roomdatabase2.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

// step 1 create  data class
@Entity
data class Customer(
    @PrimaryKey(autoGenerate = true)
    //id ne initilazation karna jaruri hai
    var id:Int=0,
    var Name:String,
    var Email:String
)
