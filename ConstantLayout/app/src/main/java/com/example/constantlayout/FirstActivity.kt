package com.example.constantlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity() {

    lateinit var btn_login :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        btn_login =findViewById(R.id.btn_login)
        btn_login.setOnClickListener {

            var intent = Intent(applicationContext,SecondActivity::class.java)
            startActivity(intent)

        }
    }

}