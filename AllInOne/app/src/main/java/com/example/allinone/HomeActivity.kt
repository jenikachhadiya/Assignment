package com.example.allinone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allinone.SharePrefrence.Prefrence
import com.example.allinone.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manger = Prefrence(this)
        var array = manger.UserDetails()
        array?.let {
            binding.tvText.text = """
                name = ${it[0]}
                email = ${it[1]}
            """.trimIndent()

        }

        binding.btnLogout.setOnClickListener {
            manger.Logout()
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }
    }
}