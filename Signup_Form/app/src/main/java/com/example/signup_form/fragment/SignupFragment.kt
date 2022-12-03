package com.example.signup_form.fragment

import android.os.Bundle
import android.os.PatternMatcher
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.signup_form.R
import com.example.signup_form.databinding.FragmentSignupBinding
import java.util.regex.Pattern

class SignupFragment : Fragment() {
    lateinit var binding: FragmentSignupBinding

//    var email = binding.etEmail.text.toString().trim()
//    var pass = binding.etPassword.text.toString().trim()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(layoutInflater)

       // setListner()

        binding.btnSignup.setOnClickListener {
            emailFocesListner()


//            var email = binding.etEmail.text.toString().trim()
//            var Pass = binding.etPassword.text.toString().trim()
//            var cpass = true
            /*  if(binding.etEmail.text.toString().isEmpty()){
                 validationemail()
                 Toast.makeText(requireActivity(), "email pleases", Toast.LENGTH_SHORT).show()

             }
             else if(binding.etPassword.text.toString().isEmpty()){
                 validationpass()
                 Toast.makeText(requireActivity(), "password pleases", Toast.LENGTH_SHORT).show()

             }
             else if(binding.etCpassword.text.toString().isEmpty()){
                 comfirmpass()
                 Toast.makeText(requireActivity(), "cpassword pleases", Toast.LENGTH_SHORT).show()

             }
             else{
                 Toast.makeText(requireActivity(), "Form Fully Filed", Toast.LENGTH_SHORT).show()
 //                if(isValidation()){
 //                    var email = binding.etEmail.text.toString().trim()
 //                    var pass = binding.etPassword.text.toString().trim()
 //                    Signup(email, pass)
                 }*/

           /* if (!validationemail(email)) {
                Toast.makeText(requireActivity(), "email plases", Toast.LENGTH_SHORT).show()
            }else if (!validationpass(Pass)) {
                Toast.makeText(requireActivity(), "password pleses", Toast.LENGTH_SHORT).show()
            }else if (!comfirmpass(cpass)) {
                Toast.makeText(requireActivity(), "cpassword pleases", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "Form Fully Filed", Toast.LENGTH_SHORT).show()
//                if(isValidation()){
//                    var email = binding.etEmail.text.toString().trim()
//                    var pass = binding.etPassword.text.toString().trim()
//                    Signup(email, pass)
            }*/

        }
        return (binding.root)
    }

    private fun emailFocesListner() {
        binding.etEmail.setOnFocusChangeListener { _, foces ->
            if (foces){
//                binding.tbEmail.error = "Email Addresss"
//                binding.etEmail.requestFocus()
                emailvalidation()
                Toast.makeText(requireActivity(), "email 1", Toast.LENGTH_SHORT).show()
            }else{
//                binding.tbEmail.isErrorEnabled = false
//                Toast.makeText(requireActivity(), "email 2", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun emailvalidation(): String? {
        var email = binding.etEmail.text.toString()
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(requireActivity(), "email validation", Toast.LENGTH_SHORT).show()


        }
        return null

    }

    private fun requestFocus() {
      /*  binding.etEmail.addTextChangedListener(TextFieldValidation(binding.etEmail))
        binding.etPassword.addTextChangedListener(TextFieldValidation(binding.etPassword))
        binding.etCpassword.addTextChangedListener(TextFieldValidation(binding.etCpassword))*/
       // binding.tbEmail.isErrorEnabled
       // binding.tbPass.isErrorEnabled
        Toast.makeText(requireActivity(), "request Focues", Toast.LENGTH_SHORT).show()
    }
    /*  private fun requestFocues() {
          var email = binding.etEmail.text.toString().trim()
          var Pass = binding.etPassword.text.toString().trim()
      }*/
    /* private fun validEmail(): String? {
         val emailtext = binding.etEmail.text.toString().trim()
         if(!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
             binding.etEmail.error = "Enter Email Address"
             binding.etEmail.requestFocus()
             return "Invalid Email Address"
             Toast.makeText(requireActivity(), "email vala nahi", Toast.LENGTH_SHORT).show()
         }
         return null
     }*/
    /* private fun validPass(): String? {
         val pass = binding.etPassword.text.toString().trim()
         if(!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$".toRegex())){
             binding.etPassword.error = "Enter Password"
             binding.etPassword.requestFocus()
             return "enter passsword"
         }
         return null

     }*/
    /* private fun ComfirmPass():Boolean?{
         val cpass = binding.etCpassword.text.toString().trim()
         if(validPass()!=cpass)
         {
             binding.etCpassword.error = "Enter Comfirm Password "
             binding.etCpassword.setText("")

         }else{
             Toast.makeText(requireActivity(), "form fild", Toast.LENGTH_SHORT).show()
         }

         return true
     }*/

    private fun setListner() {
        Toast.makeText(requireActivity(), "set listner", Toast.LENGTH_SHORT).show()
//        var email = binding.etEmail.addTextChangedListener(TextFieldValidation(binding.etEmail))
//        var pass =  binding.etPassword.addTextChangedListener(TextFieldValidation(binding.etPassword))
//        var cpass = binding.etCpassword.addTextChangedListener(TextFieldValidation(binding.etCpassword))

    }

    inner class TextFieldValidation(var view: View) : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // binding.etCpassword.text=null

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            when (view.id) {
                R.id.et_Email -> {
                    var email = binding.etEmail.text.toString().trim()

                   // validationemail(email)
                    emailvalidation()
                    Toast.makeText(requireActivity(), "id valo code", Toast.LENGTH_SHORT).show()

                }
                R.id.et_password -> {
                    var Pass = binding.etPassword.text.toString().trim()
                    //validationpass(Pass)
                    Toast.makeText(requireActivity(), "id valo code", Toast.LENGTH_SHORT).show()
                }
                R.id.et_Cpassword -> {
                    //comfirmpass()
                    Toast.makeText(requireActivity(), "id valo code", Toast.LENGTH_SHORT).show()
                }

            }

        }


        override fun afterTextChanged(p0: Editable?) {

        }
    }

    /*   private fun isValidation(): Boolean {
           if (validationemail() && validationpass() && comfirmpass()) {
               return true

           } else {
   //            var email = binding.etEmail.text.toString().trim()
   //            var pass = binding.etPassword.text.toString().trim()
   //            Signup(email, pass)

           }
           return false

       }*/
  /*  private fun comfirmpass(cpassword:Boolean): Boolean {

*//*
        if (binding.etCpassword.text.toString().trim() != binding.etPassword.text.toString()
                .trim()
        ) {
            //binding.etCpassword.setText("")
            binding.tbCpass.error = " Enter Current Password"
            //binding.etCpassword.text=null
            binding.etCpassword.requestFocus()

            return false
        } else if (binding.etCpassword.text.toString() != binding.etPassword.text.toString()) {
            binding.etCpassword.setText("")
            return false
        } else {
            binding.tbCpass.isErrorEnabled = false

        }*//*
        if (binding.etPassword.text.toString().trim() != binding.etCpassword.text.toString().trim()){
            //binding.etCpassword.setText("")
            binding.tbCpass.error = " Enter Current Password"
            //binding.etCpassword.text=null
            binding.etCpassword.requestFocus()
            Toast.makeText(requireActivity(), "if cpassword", Toast.LENGTH_SHORT).show()

        }else{
            binding.tbCpass.isErrorEnabled = false
            Toast.makeText(requireActivity(), "else cpassword", Toast.LENGTH_SHORT).show()
        }
        return true
    }*/

  /*  private fun validationemail(email: String): Boolean {
         var email = binding.etEmail.text.toString().trim()
         var metch = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (metch) {
            binding.tbEmail.isErrorEnabled = false
            Toast.makeText(requireActivity(), "else email", Toast.LENGTH_SHORT).show()

        }else{
            binding.tbEmail.error = "Email Addresss"
            binding.etEmail.requestFocus()
            Toast.makeText(requireActivity(), "if email", Toast.LENGTH_SHORT).show()
        }
        return true

    }*/

   /* private fun validationpass(password: String): Boolean {
         var password = binding.etPassword.text.toString()
        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        var metch = Pattern.compile(regex).matcher(password).matches()
        if (metch){
            binding.tbPass.isErrorEnabled = false
            Toast.makeText(requireActivity(), "else email", Toast.LENGTH_SHORT).show()
        }else{
            binding.tbPass.error = "Email Addresss"
            binding.etPassword.requestFocus()
            Toast.makeText(requireActivity(), "if email", Toast.LENGTH_SHORT).show()
        }

        return true
    }*/


}