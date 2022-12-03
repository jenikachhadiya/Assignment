package com.example.roomdatabase2.database

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.roomdatabase2.DAOs.CustomDAOs
import com.example.roomdatabase2.entity.Customer

//create data class
//1.Database (entitits = class ::class,version = defalut 1)
@Database(entities = [Customer::class],version = 1)
//Innherit Room Database abstract class create
 abstract class DataBase :RoomDatabase(){

    //abstrct customDaos ne Inherit karo
    abstract fun customDaos():CustomDAOs
}