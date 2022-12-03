package com.example.mvvmjet_com.Activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmjet_com.Reposetrie.UserlistRepo
import com.example.retrofitgetmethod.Modal.UserResponse
import com.example.retrofitgetmethod.Modal.user

class MainviewModal:ViewModel() {

   // var userlivedata = MutableLiveData<List<user>>()

    //fatch data
    val fatchuserlist:LiveData<List<user>>
    get() = UserlistRepo.lodlistdata()


    val isLoding :LiveData<Boolean>
    get() = UserlistRepo.getLodingProcc()



}