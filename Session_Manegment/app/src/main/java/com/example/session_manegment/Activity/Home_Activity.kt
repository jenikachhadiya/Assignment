package com.example.session_manegment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.session_manegment.R
import com.example.session_manegment.SharePrefrence.Prefrence
import com.example.session_manegment.databinding.ActivityHomeBinding

class Home_Activity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manger = Prefrence(this)
         var array = manger.userdetail()
        array?.let {
            binding.tvText.text ="""
                name = ${it[0]}
                email = ${it[1]}
            """.trimIndent()


        }


        binding.btnLogout.setOnClickListener {

            manger.logout()
            startActivity(Intent(applicationContext,Login_Activity::class.java))

        }
    }
}