package com.example.mvpmodal_view_presenter.Activitys.fatch_list

import android.os.Message
import com.example.mvpmodal_view_presenter.Modal.user

//main activity and presenter vache comunication thay che
interface MainView {
    fun showprogres()
    fun hideprogres()
    fun success(userlist:List<user>)
    fun failer(message: String)
}