package com.example.roomdatabase2.DAOs

import androidx.room.*
import com.example.roomdatabase2.entity.Customer

//@Dao inter face and crareat methhod  for impliment and add query

@Dao
interface CustomDAOs {

    //insert DAos
    @Insert
    fun InsertData(customer: Customer)

    //Updata
    @Update
    fun UpdateData(customer: Customer)

    //Delete
    @Delete
    fun DeleteData(customer: Customer)

    //get all list
    @Query("Select * From customer")
    fun GetAllList():List<Customer>

    //get id custom
    @Query("Select * From customer where id = :id")
    fun Getuser(id:Int):Customer


}