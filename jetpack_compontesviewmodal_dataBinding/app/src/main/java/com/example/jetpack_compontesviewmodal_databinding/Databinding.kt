package com.example.jetpack_compontesviewmodal_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.jetpack_compontesviewmodal_databinding.databinding.ActivityDatabindingBinding

class Databinding : AppCompatActivity() {

    val tvname: TextView
        get() = findViewById(R.id.tv_name)

    val tvemail: TextView
        get() = findViewById(R.id.tv_email)

    lateinit var binding: ActivityDatabindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_databinding)
        //setContentView(R.layout.activity_databinding)

       // tvname.text = "Jeni"
       // tvemail.text = "Jeni@gmail.com"

        binding.person = Person("Jeni","Jeni@gmail.com")

        findViewById<Button>(R.id.btn_update).setOnClickListener {

            binding.person = Person("Too","Too@gmail.com")

        }


    }
}