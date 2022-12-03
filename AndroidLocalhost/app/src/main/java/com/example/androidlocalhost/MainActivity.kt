package com.example.androidlocalhost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.androiddependentapicalling.network.callback.RegisterCallback
import com.app.androidlocalhost.network.ApiClient
import com.example.androidlocalhost.databinding.ActivityMainBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCreate.setOnClickListener {
            Toast.makeText(applicationContext, "click", Toast.LENGTH_SHORT).show()
            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobile = binding.etContect.text.toString().trim()

            createAccoundMethod(name, email, mobile)

        }


    }

    private fun createAccoundMethod(name: String, email: String, mobile: String) {


        /*APIClints.init().createAccount(flag = 1, name = name, email = email, contect = mobile).enqueue(
            object : Callback<RagisterCallBack> {
                override fun onResponse(
                    call: Call<RagisterCallBack>,
                    response: Response<RagisterCallBack>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT)
                                .show()


                            // Toast.makeText(applicationContext, "create account", Toast.LENGTH_SHORT).show()
                            if (it.status == "success" && it.user != null) {

                                //navigrat to login
                                startActivity(Intent(applicationContext, HomeActivity::class.java))
                                finishAffinity()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<RagisterCallBack>, t: Throwable) {

                }

            }
        )*/


        ApiClient.init().register(1, name, email, mobile).enqueue(object :
            Callback<RegisterCallback>{
            override fun onResponse(
                call: Call<RegisterCallback>,
                response: Response<RegisterCallback>
            ){
                if(response.isSuccessful){
                    Toast.makeText(applicationContext, "message", Toast.LENGTH_SHORT).show()
                    response.body()?.let {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()


                        // Toast.makeText(applicationContext, "create account", Toast.LENGTH_SHORT).show()
                        if (it.status == "Success" && it.user != null) {

                            //navigrat to login
                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                            finishAffinity()
                        }
                    }
                }


            }

            override fun onFailure(call: Call<RegisterCallback>, t: Throwable) {

            }

        })


    }
}