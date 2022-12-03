package com.example.post_localhost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.post_localhost.databinding.ActivityMainBinding
import com.example.post_localhost.interfacee.ApiClint
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

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobile = binding.etContec.text.toString().trim()
            var password = binding.etPass.text.toString().trim()


            if (name.isEmpty()){
                seterror(binding.etName,"enter name")
            }else if (email.isEmpty()){
                seterror(binding.etEmail,"enter Email")
            }else if (mobile.isEmpty()){
                seterror(binding.etContec,"enter mobile")
            }else if (password.isEmpty()){
                seterror(binding.etPass,"enter password")
            }else{
                creatAccount(name,email,mobile,password)
            }

        }

    }

    private fun creatAccount(name: String, email: String, mobile: String, password: String) {

        ApiClint.Init().insert(1,name,email,mobile, password)
            .enqueue(object : Callback<student>{
            override fun onResponse(call: Call<student>, response: Response<student>) {

                if (response.isSuccessful){
                    response.body()
                    Toast.makeText(this@MainActivity, "is successful", Toast.LENGTH_SHORT).show()
                   startActivity(Intent(applicationContext,HomeActivity::class.java))
                }
            }

            override fun onFailure(call: Call<student>, t: Throwable) {
                Toast.makeText(this@MainActivity, "is failed", Toast.LENGTH_SHORT).show()
            }

        })



    }

    private fun seterror(editText: EditText, error: String) {

        Toast.makeText(this, "$error", Toast.LENGTH_SHORT).show()

    }
}