package com.example.localhost.Shareprefrence

import android.content.Context
import android.content.SharedPreferences
import com.example.localhost.Modal.User
import com.google.gson.Gson

class PrefrenceClass(context: Context) {

    private var Pref_name = "Pref_user"
    private var Login_Stuts = "Is_Login"
    var USER = "user"


    private var SharedPreferences = context.getSharedPreferences(Pref_name, Context.MODE_PRIVATE)
    private var editor = SharedPreferences.edit()


    fun getlogin(): Boolean {

        return SharedPreferences.getBoolean(Login_Stuts, false)

    }

    fun setlogin(status: Boolean): Boolean {

        return SharedPreferences.getBoolean(Login_Stuts, status)

    }

    fun setUser(user: User) {
        //convet to json to gson
        var gson = Gson()
        var jsonString = gson.toJson(user)

        editor.putString(USER, jsonString)
        editor.commit()


    }


}