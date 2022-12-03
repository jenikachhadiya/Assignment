package com.example.google_facebook_login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.google_facebook_login.databinding.ActivityHomeBinding
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.GraphRequest.GraphJSONObjectCallback
import com.facebook.GraphResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import org.json.JSONObject


class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    lateinit var gso: GoogleSignInOptions
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("1017508136636-h3351tdlrtjbu8mfh4ai8p303jbf64op.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        val acct = GoogleSignIn.getLastSignedInAccount(this)
        if (acct != null) {
            val personName = acct.displayName
            val personGivenName = acct.givenName
            val personFamilyName = acct.familyName
            val personEmail = acct.email
            val personId = acct.id
            val personPhoto: Uri? = acct.photoUrl

            binding.tvResult.text = """
                $personName
                $personGivenName
                $personFamilyName
                $personEmail
                $personId
                $personPhoto              
            """.trimIndent()

        }

        //facebook
       var accessToken = AccessToken.getCurrentAccessToken()


        accessToken?.let {
            val request = GraphRequest.newMeRequest(
                it
            ) { jsonObject, response ->
                // Application code
                print(jsonObject)
                Log.d("TAG", "onComplate:$jsonObject")
                var name = jsonObject?.getString("name")


            }
            val parameters = Bundle()
            parameters.putString("fields", "id,name,link,email,birthday,hometown")
            request.parameters = parameters
            request.executeAsync()
        }






        binding.btnLogout.setOnClickListener {

            googleSignInClient.signOut()
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        Toast.makeText(
                            applicationContext,
                            "LogOut Successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finishAffinity()
                    }

                }

        }


    }
}