package com.example.checkpostapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.checkpostapi.databinding.ActivityMainBinding
import com.example.checkpostapi.modal.createcallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //please run in emulater sdk run only

        binding.btnCreate.setOnClickListener {
            Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()

            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val mobile = binding.etContec.text.toString().trim()
            val pass = binding.etPass.text.toString().trim()

           // Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
            createAccount(name,email,mobile,pass)
          //  Toast.makeText(applicationContext, "3", Toast.LENGTH_SHORT).show()

        }

    }

    private fun createAccount(name: String, email: String, mobile: String, pass: String) {

        Apiclient.Init().createacc(1,name,email,mobile,pass).enqueue(object : Callback<createcallback>{
            override fun onResponse(
                call: Call<createcallback>,
                response: Response<createcallback>
            ) {
                Toast.makeText(applicationContext, "clicke", Toast.LENGTH_SHORT).show()
                if (response.isSuccessful){
                    Toast.makeText(applicationContext, "clicke 2", Toast.LENGTH_SHORT).show()
                    response.body()?.let {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()

                        //save data
                        if (it.status == "success"){
                            //navigrat to home
                         startActivity(Intent(applicationContext,HomeActivity::class.java))
                            finishAffinity()
                        }
//&& it.user!=null

                    }
                }

            }

            override fun onFailure(call: Call<createcallback>, t: Throwable) {


            }

        })

    }
}