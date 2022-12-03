package com.example.livedata

import androidx.lifecycle.ViewModel

class MainViewModal(var initilvalue :Int):ViewModel() {

    var counter = initilvalue
    fun getcounter():Int{
        return counter
    }
    fun increment(){
        counter++
    }
    fun decriment(){
        counter--
    }



}