package com.example.mvvmjet_com.Reposetrie

import androidx.lifecycle.MutableLiveData
import com.example.mvpmodal_view_presenter.network.Api_Clinte
import com.example.retrofitgetmethod.Modal.UserResponse
import com.example.retrofitgetmethod.Modal.user
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserlistRepo {

    private var liveData = MutableLiveData<List<user>>()
    private var IsLoding = MutableLiveData<Boolean>()


    fun lodlistdata():MutableLiveData<List<user>> {

        IsLoding.value = true

        Api_Clinte.init().getuserlist().enqueue(object : Callback<UserResponse> {

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                IsLoding.value = false
                if (response.isSuccessful){

                    response.body()?.let {

                        liveData.value = it.Userlist

                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                liveData.value = mutableListOf()
                IsLoding.value = false
            }


        })
        return liveData

    }

    fun getLodingProcc(): MutableLiveData<Boolean> {
        return IsLoding
    }

}