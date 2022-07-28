package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class fourthActivity : AppCompatActivity() {

    val tvEmail :TextView
    get() = findViewById(R.id.et_EmailA)

    val tvpass : TextView
    get() = findViewById(R.id.et_Pass)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        var Email = intent.getStringExtra("Email")
        var pass = intent.getStringExtra("Pass")

        tvEmail.text = "Email Address $Email"
        tvpass.text = "Password = $pass"




    }
}