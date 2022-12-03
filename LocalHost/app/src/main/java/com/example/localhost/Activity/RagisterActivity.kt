package com.example.localhost.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.localhost.Interface.ApiClient
import com.example.localhost.R
import com.example.localhost.Shareprefrence.PrefrenceClass
import com.example.localhost.databinding.ActivityRagisterBinding
import com.example.localhost.network.RegisterCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RagisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRagisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRagisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSubmit.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var pass = binding.etPassword.text.toString().trim()
            var mobile = binding.etContect.text.toString().trim()

            if (name.isEmpty()) {
                setError(binding.etName, "enter name")
            } else if (email.isEmpty()) {
                setError(binding.etEmail, "enter Email")
            } else if (mobile.isEmpty()) {
                setError(binding.etContect, "enter mobile")
            } else if (pass.isEmpty()) {
                setError(binding.etPassword, "enter pass")
            }
            else {
                createAccount(name, email, mobile, pass)
                //startActivity(Intent(applicationContext,HomeActivity::class.java))
            }

        }
        binding.btLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }



    }
    private fun setError(editText: EditText, error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        editText.requestFocus()
    }

    private fun createAccount(name: String, email: String, mobile: String, pass: String) {
        ApiClient.init().register(1, name, email, mobile, pass)
            .enqueue(object : Callback<RegisterCallback> {
                override fun onResponse(
                    call: Call<RegisterCallback>,
                    response: Response<RegisterCallback>
                ){
                    var res = response?.body()
                    res?.let {
                        if (it.status == "success") {
                            var manger = PrefrenceClass(applicationContext)
                            manger.setlogin(true)
                            manger.setUser(it.user)
                            startActivity(Intent(this@RagisterActivity, HomeActivity::class.java))
                            Toast.makeText(this@RagisterActivity, "thy", Toast.LENGTH_SHORT).show()
                        }
                        Toast.makeText(this@RagisterActivity, "${it.message}", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<RegisterCallback>, t: Throwable) {
                    Toast.makeText(this@RagisterActivity, t.toString(), Toast.LENGTH_SHORT).show()
                }


            })


    }
}