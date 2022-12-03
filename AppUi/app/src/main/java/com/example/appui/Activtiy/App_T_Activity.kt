package com.example.appui.Activtiy

import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appui.R
import com.example.appui.databinding.ActivityAppTactivityBinding

class App_T_Activity : AppCompatActivity() {

    lateinit var  binding:ActivityAppTactivityBinding
    lateinit var dialog : ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityAppTactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog = ProgressDialog(this).apply {
            setTitle("Plasese Wait ")
            setMessage("Preparing to download")
            setCancelable(false)
        }


        binding.btnSignin.setOnClickListener {

          //  dialog.show()

            //progress circle
            binding.progCircal.visibility = View.VISIBLE

            Thread(Runnable {
                Thread.sleep(3000)

                runOnUiThread{

                   /* if (dialog.isShowing){
                        dialog.dismiss()
                    }*/

                    //progress circle

                    binding.progCircal.visibility = View.GONE

                    Toast.makeText(applicationContext, "navigrat to home page",Toast.LENGTH_SHORT)
                        .show()
                }

            }).start()


            // data store in blank page

            val toast = Toast.makeText(applicationContext, "Data store",Toast.LENGTH_SHORT)
            toast.show()

        }
        binding.btnSignup.setOnClickListener {

            //navigration on second page
            var intent = Intent(this,App_For_Activity::class.java)
            startActivity(intent)
        }
    }
}