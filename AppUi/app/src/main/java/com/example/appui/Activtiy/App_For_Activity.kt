package com.example.appui.Activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.appui.R
import com.example.appui.databinding.ActivityAppForBinding
import java.util.regex.Pattern

class App_For_Activity : AppCompatActivity() {

    var ischecked = false
    var isdarkmode = true


    lateinit var binding: ActivityAppForBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppForBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignup.setOnClickListener {

           requestFocues()

            var fname = binding.etFname.text.toString().trim()
            var lname = binding.etLname.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contect = binding.etContec.text.toString().trim()
            var Pass = binding.etPass.text.toString().trim()
            var CPass = binding.etCPass.text.toString().trim()

            if (fname.isEmpty()){
                //Show error
               // binding.etFname.error = " Enter FirstName"
                seteror(binding.etFname,"enter first name")

            }else if (lname.isEmpty()){
                //show error
               // binding.etLname.error = " Enter lastName"
                seteror(binding.etLname,"enter Last name")
            }else if (!isValidEmail(email)){
                //show error
               // binding.etEmail.error = " Enter Email"
                seteror(binding.etEmail,"enter Email address")
            }else if (!isValidContect(contect)){
                //show error
               // binding.etContec.error = " Enter Contect"
                seteror(binding.etContec,"enter Contect")
            }else if (gender.isEmpty()){
                //
              seteror(error = "select gender")

            } else if (!isValidPassword(Pass)){
                //show error
               // binding.etPass.error = " Enter Password"
                seteror(binding.etPass,"enter password")
            }else if (Pass != CPass){
                //blank line
               // binding.etCPass.error= " password mismech"
                seteror(binding.etCPass,"password mismech")
                binding.etCPass.setText("")
            }else if (!ischecked){
                //error show
                seteror(error = "pleses  cheak condition")

            }else{
                //all fild are execute
                Toast.makeText(applicationContext,"form is fully filled",Toast.LENGTH_SHORT).show()
            }

        }

        //checked box
        binding.chkBox.setOnCheckedChangeListener { compoundButton, checked ->
            ischecked = checked

        }

        //switch button clicked event
        binding.swhDm.setOnCheckedChangeListener { compoundButton, checked ->
            isdarkmode = checked
        }




    }

    private fun requestFocues() {
        binding.etFname.setBackgroundResource(R.drawable.button_color)
        binding.etLname.setBackgroundResource(R.drawable.button_color)
        binding.etEmail.setBackgroundResource(R.drawable.button_color)
        binding.etPass.setBackgroundResource(R.drawable.button_color)
        binding.etCPass.setBackgroundResource(R.drawable.button_color)
        binding.etContec.setBackgroundResource(R.drawable.button_color)


    }

    private fun seteror(editText: EditText?=null,error :String){

        editText?.let {
            it.setBackgroundResource(R.drawable.gragiyant)
            it.requestFocus()
        }
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show()

    }



    private fun isValidPassword(Pass: String): Boolean {
        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        return Pattern.compile(regex).matcher(Pass).matches()
    }

    private  fun isValidContect(contect:String) : Boolean{

        return contect.length == 10
    }

    private  fun isValidEmail(email:String) : Boolean{

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    var gender = ""

    fun onrb_ButtonClike(view: View) {
       gender = when(view.id){
            R.id.rb_male ->"male"
            R.id.rb_female ->"female"
            R.id.rb_other ->"other"
           else -> ""
        }




    }


}