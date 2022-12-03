package com.example.`object`

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.objects.objects

class First : AppCompatActivity() {
    lateinit var btn_Submit :Button
    lateinit var et_name :EditText
    lateinit var et_email:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)




        btn_Submit = findViewById(R.id.btn_submit)
        et_name = findViewById(R.id.et_name)
        et_email=findViewById(R.id.et_name)


        btn_Submit.setOnClickListener {

            var name = et_name.text.toString().trim()
            var email = et_email.text.toString().trim()

            var objec = objects(name, email)




            //navigrat to one activity to another activity
            var intent = Intent(applicationContext, Second::class.java)

            intent.putExtra("OBJ",objec)
            startActivity(intent)

        }


    }
}