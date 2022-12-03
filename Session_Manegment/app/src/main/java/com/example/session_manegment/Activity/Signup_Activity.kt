package com.example.session_manegment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.example.session_manegment.R
import com.example.session_manegment.SharePrefrence.Prefrence
import com.example.session_manegment.databinding.ActivitySignupBinding

class Signup_Activity : AppCompatActivity() {

    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var pass = binding.etPass.text.toString().trim()

            Signup(name,email,pass)



        }

    }
    private fun Signup(name:String,email:String,pass:String){

        var manger = Prefrence(this)
        manger.SaveDetail(name,email,pass)
        manger.setLoginStatus(true)
        Toast.makeText(applicationContext, "Account Create Successfully", Toast.LENGTH_SHORT)
            .show()
        startActivity(Intent(applicationContext,Home_Activity::class.java))


    }
}