package com.example.jetpack_compontesviewmodal_databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainviewModal(var initialValue:Int):ViewModel() {

   // var counter = 0
    //by defalt public hoy che but jo privat karoi to counter ne aviretite get karvani ray
    private var counter = initialValue
    //main acitvity ma nadeta a class ma fun banvi ne eexecute kari skaiye chia

    var counterlivedata = MutableLiveData<Int>(initialValue)


   /* fun getcounter():Int{
        return counter
    }
*/
    fun increments(){
     counterlivedata.value = ++counter
    }

    fun decrements(){
        counterlivedata.value = --counter
    }


}