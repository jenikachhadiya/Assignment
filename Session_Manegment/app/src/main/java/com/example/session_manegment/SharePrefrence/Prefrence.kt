package com.example.session_manegment.SharePrefrence

import android.content.Context
import javax.net.ssl.SSLEngineResult

class Prefrence (context: Context){

    private  val Pref_Name  = "User_Recod"
    private val NAME = "name"
    private val EMAIL = "email"
    private val PASS = "password"
    private val Is_Login = "isLogin"

    private var sherprefrence  = context.getSharedPreferences(Pref_Name,Context.MODE_PRIVATE)
    private var editor = sherprefrence.edit()

    fun SaveDetail(name:String,email:String,pass:String)
    {
        //set data parmiter variable in to putsting in pass key and value
        editor.putString(NAME,name)
        editor.putString(EMAIL,email)
        editor.putString(PASS,pass)
        editor.commit()

    }
    //set stutas updateing
    fun setLoginStatus(status:Boolean){
        editor.putBoolean(Is_Login,status)
        editor.commit()
    }
    //set status updating
    fun getLoginStatus():Boolean{
       return sherprefrence.getBoolean(Is_Login,false)
    }

    fun userdetail():Array<String?>{
        var name = sherprefrence.getString(NAME,"")
        var email = sherprefrence.getString(EMAIL,"")

        return  arrayOf(name,email)

    }

    fun logout(){
        editor.clear()
        editor.commit()

    }


}