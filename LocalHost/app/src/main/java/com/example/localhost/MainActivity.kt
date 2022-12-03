package com.example.localhost


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.localhost.Activity.HomeActivity
import com.example.localhost.Interface.ApiClient
import com.example.localhost.databinding.ActivityMainBinding
import com.example.localhost.network.RegisterCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      /*  binding.btnCreate.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobile = binding.etContact.text.toString().trim()

            createAccount(name, email, mobile)
            //Toast.makeText(this, "thy che hoo", Toast.LENGTH_SHORT).show()


        }*/

    }

   /* private fun createAccount(name: String, email: String, mobile: String) {
        ApiClient.init().register(1, name, email, mobile).enqueue(object :
            Callback<RegisterCallback> {
            override fun onResponse(
                call: Call<RegisterCallback>,
                response: Response<RegisterCallback>
            ) {
                if (response.isSuccessful) {

                    response.body()?.let {
                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()

                        if (it.status == "success" && it.user != null) {
                            // save data shared preference
                            // navigate to home
                            // navigate to login
                           startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                            finishAffinity()
                        }
                    }


                }


            }

            override fun onFailure(call: Call<RegisterCallback>, t: Throwable) {

            }

        })

    }*/
}
