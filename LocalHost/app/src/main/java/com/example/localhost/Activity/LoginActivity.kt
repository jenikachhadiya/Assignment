package com.example.localhost.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.localhost.Interface.ApiClient
import com.example.localhost.Shareprefrence.PrefrenceClass
import com.example.localhost.databinding.ActivityLoginBinding
import com.example.localhost.network.RegisterCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.udSignin.setOnClickListener {

            var email = binding.udEmail.text.toString().trim()
            var pass = binding.udPassword.text.toString().trim()

            if (email.isEmpty()){
                Toast.makeText(this, "email enter pleases", Toast.LENGTH_SHORT).show()
            }else if (pass.isEmpty()){
                Toast.makeText(this, "password enter pleases", Toast.LENGTH_SHORT).show()
            }else {
                userLogin(email,pass)

                //startActivity(Intent(applicationContext,HomeActivity::class.java))
            }

        }
        binding.udSignUp.setOnClickListener {

            startActivity(Intent(applicationContext,RagisterActivity::class.java))

        }


    }

    private fun userLogin(email: String, pass: String) {

        ApiClient.init().LoginUser(6,email,pass)
            .enqueue(object : Callback<RegisterCallback> {
            override fun onResponse(
                call: Call<RegisterCallback>,
                response: Response<RegisterCallback>
            ) {

                if(response.isSuccessful){

                    response.body()?.let {

                        var manger = PrefrenceClass(this@LoginActivity)
                        manger.setlogin(true)

                        startActivity(Intent(this@LoginActivity,HomeActivity::class.java))

                    }
                }

            }

            override fun onFailure(call: Call<RegisterCallback>, t: Throwable) {
                Toast.makeText(this@LoginActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })


    }
}