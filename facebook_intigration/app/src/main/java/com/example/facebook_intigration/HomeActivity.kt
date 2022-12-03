package com.example.facebook_intigration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.facebook_intigration.databinding.ActivityHomeBinding
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.login.LoginManager
import org.json.JSONObject

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //logout codeing
        binding.btnLogout.setOnClickListener {
            LoginManager.getInstance().logOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }





//f1
        var accessToken = AccessToken.getCurrentAccessToken()
//f2
        accessToken?.let {
            val request = GraphRequest.newMeRequest(it,object : GraphRequest.GraphJSONObjectCallback{
                override fun onCompleted(jsonObject: JSONObject?, response: GraphResponse?) {

                    jsonObject?.let {

                        var id = it.getString("id")
                        var name = it.getString("name")
                        var pictureurl = it.getJSONObject("picture").getJSONObject("data").getString("url")

                        Glide.with(applicationContext)
                            .load(pictureurl)
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(binding.ivProfile)
                        binding.tvResult.text = " id:$id\n name:$name"


                    }
                    Log.d("TAG", "onCompleted: $jsonObject")
                }

            })
            val parameters = Bundle()
            parameters.putString("fields", "id,name,link,picture.type(large),email,birthday,hometown")
            request.parameters = parameters
            request.executeAsync()
        }
    }
}