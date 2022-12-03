package com.example.allinone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.allinone.SharePrefrence.Prefrence
import com.example.allinone.databinding.ActivityRagisterBinding

class RagisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRagisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRagisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {


            var name = binding.etName.text.toString()
            var email = binding.etEmail.text.toString()
            var pass = binding.etPass.text.toString()

            //validation code
            Ragistar(name,email,pass)

        }
    }

    private fun Ragistar(name: String, email: String, pass: String) {

        var manger = Prefrence(this)
        manger.SaveData(name, email, pass)
        manger.setloginstatus(true)
        Toast.makeText(applicationContext, "create account", Toast.LENGTH_SHORT).show()
        startActivity(Intent(applicationContext,HomeActivity::class.java))
    }
}