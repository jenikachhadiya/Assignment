package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

    lateinit var btnSubmit :Button
    lateinit var etName: EditText
    lateinit var etEmail:EditText
    lateinit var etAge :EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

     etName = findViewById(R.id.et_Name)
     etEmail = findViewById(R.id.et_Email)
    etAge = findViewById(R.id.et_Age)
    btnSubmit = findViewById(R.id.btn_Submit)
        println("activity Created")


        //click event of button...
     btnSubmit.setOnClickListener{

         var name = etName.text.toString().trim()
         var email = etEmail.text.toString().trim()
         var age = etAge.text.toString().trim().toInt()


        /* //navigrete form one activity to another activity
         var intent = Intent(applicationContext,SecActivity ::class.java)

         intent.putExtra("NAME",name)
         intent.putExtra("EMAIL",email)
         intent.putExtra("AGE",age.toInt())

         startActivity(intent) // execute thay
*/


         // pasing object ........


         var user = User(name,email,age.toInt())

         // passing object from one activity to another

         var intent = Intent(applicationContext,SecActivity::class.java)
         intent.putExtra("USER",user)


         startActivity(intent)


     }


    }

}