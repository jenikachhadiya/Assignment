package com.example.google_facebook_login

import android.content.Intent
import android.os.Bundle
import android.util.Log

import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.google_facebook_login.databinding.ActivityMainBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
   lateinit var gso:GoogleSignInOptions
   lateinit var googleSignInClient: GoogleSignInClient
   private  var RC_SIGN_IN = 100


    //facebook
    private lateinit var callbackManager:CallbackManager


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //f1
        callbackManager = CallbackManager.Factory.create();

            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onCancel() {

                    }

                    override fun onError(error: FacebookException) {

                    }

                    override fun onSuccess(result: LoginResult) {
                     //   Log.d("TAG", "onSuccess: ")
                        result?.let {
                            navigrattoHome(null)
                        }
                    }


                })
            //f2
            binding.btnFacebook.setOnClickListener {
//f3
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
            }




//s 1
         gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

//s2
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        binding.btnGoogle.setOnClickListener {
//s4
            signIn()
        }
    }
    //s3
    private fun signIn() {
        val signInIntent: Intent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    //s5
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK){
//S6
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            //s7
            handleSignInResult(task)

        }
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>) {
//s8
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            navigrattoHome(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.

           // updateUI(null)
        }

    }
//s9
    private fun navigrattoHome(account: GoogleSignInAccount?) {

    account?.let {
        Toast.makeText(this, "welcome to home ${account.displayName}", Toast.LENGTH_SHORT).show()
    }

      //  Toast.makeText(this, "welcome to home ${account.displayName}", Toast.LENGTH_SHORT).show()

        startActivity(Intent(applicationContext,HomeActivity::class.java))

    }
//s10
    override fun onResume() {
        super.onResume()
    val account = GoogleSignIn.getLastSignedInAccount(this)

       account?.let{
           navigrattoHome(it)

       }
    }
}