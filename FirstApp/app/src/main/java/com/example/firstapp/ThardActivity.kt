package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ThardActivity : AppCompatActivity() {

    lateinit var btncontinue : Button
    lateinit var etEmail :EditText
    lateinit var etPass :EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thard)

        btncontinue = findViewById(R.id.btn_Continue)
        etEmail = findViewById(R.id.et_EmailA)
        etPass = findViewById(R.id.et_Pass)

        btncontinue.setOnClickListener{
           var Email = etEmail.text.toString().trim()
            var pass = etPass.text.toString().trim()


            var intent = Intent(applicationContext,fourthActivity::class.java)
            intent.putExtra("Email",Email)
            intent.putExtra("Pass",pass)


            startActivity(intent)


        }



    }
}