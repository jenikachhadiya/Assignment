package com.example.app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button


class First_Activity : AppCompatActivity() {


    lateinit var btn_login:Button
    lateinit var btn_signup:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        btn_login = findViewById(R.id.btn_login)

        btn_signup= findViewById(R.id.btn_signup)

        btn_login.setOnClickListener {

        var intent = Intent(applicationContext,Second_Activity::class.java)

            startActivity(intent)


        }
        btn_signup.setOnClickListener{
            var intent = Intent(applicationContext,Thard_Activity::class.java)
            startActivity(intent)
        }


    }







}