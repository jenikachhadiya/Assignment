package com.example.roomdatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.DAOs.UserDAOs
import com.example.roomdatabase.entity.User

@Database(entities = [User::class], version = 1)
 abstract class AppDatabase :RoomDatabase(){

    //inherit daos class
    abstract fun userdao():UserDAOs

}

