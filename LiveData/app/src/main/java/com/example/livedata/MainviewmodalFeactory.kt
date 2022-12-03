package com.example.livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainviewmodalFeactory(var counter:Int):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return MainViewModal(counter) as T

    }

}