package com.example.roomdatabase.DAOs

import androidx.room.*
import com.example.roomdatabase.entity.User

//second step create DAOS create and add method for useing
@Dao
interface UserDAOs {

    //add @ and add what are qures
    @Insert
    fun InsertData(user: User)

    @Update
    fun UpdateData(user: User)

    @Delete
    fun DelateData(user: User)

    //all data geting from user table
    @Query("Select * From user")
    fun GetAllData():List<User>

    //single recod geting from user
    @Query("Select * From user where id = :id")
    fun Getuser(id:Int): User



}