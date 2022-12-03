package com.example.viewmodal

import androidx.lifecycle.ViewModel

//view modal ne inherit karvanu
class MainviewModal : ViewModel() {
    private var counter = 0

    fun getcounter():Int{
        return counter
    }


    fun increment(){
     counter++
    }
    fun dencrement(){
        counter--

    }
}