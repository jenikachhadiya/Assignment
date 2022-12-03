package com.example.allinone.SharePrefrence

import android.content.Context
import android.content.SharedPreferences
import java.sql.ClientInfoStatus

class Prefrence(context: Context) {

    private var prf_name = "User_Record"
    private var login_Status = "IsLogin"


    private var Name = "Name"
    private var Email = "Email"
    private var Pass = "Pass"


    private var SharedPreferences = context.getSharedPreferences(prf_name, Context.MODE_PRIVATE)
    private var editor = SharedPreferences.edit()

    //check login status
    fun setloginstatus(status: Boolean): Boolean {
        return SharedPreferences.getBoolean(login_Status, status)
    }


    //check login status
    fun getloginstatus(): Boolean {
        return SharedPreferences.getBoolean(login_Status, false)
    }

    //data save methode
    fun SaveData(name: String, email: String, pass: String) {

        editor.putString(Name, name)
        editor.putString(Email, email)
        editor.putString(Pass, pass)
        editor.commit()

    }

    //user details
    fun UserDetails(): Array<String?> {
        var name = SharedPreferences.getString(Name, "")
        var email = SharedPreferences.getString(Email, "")

        return arrayOf(name, email)

    }
    //logout
    fun Logout() {
        editor.clear()
        editor.commit()
    }


}