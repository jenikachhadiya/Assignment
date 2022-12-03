package com.example.jetpack_compontesviewmodal_databinding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class mainViewModalFactory(var counter:Int):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainviewModal(counter) as T

    }


}