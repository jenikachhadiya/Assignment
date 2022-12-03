package com.example.roomdatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

//step 1  create table
//table create
@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String,
    var email:String

)
