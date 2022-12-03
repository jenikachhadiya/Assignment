package com.example.mvpmodal_view_presenter.Activitys.fatch_list

import com.example.mvpmodal_view_presenter.network.Api_Clinte
import com.example.mvpmodal_view_presenter.network.Callback.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var view: MainView) {


    fun loadUserList() {

 view.showprogres()
        var callback = Api_Clinte.init().getuserlist()
        callback.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
view.hideprogres()
                //success
                if (response.isSuccessful) {
                    response.body()?.let {
                        view.success(it.Userlist)
                    }


                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.hideprogres()
                view.failer("no internet")
            }

        })
    }

}