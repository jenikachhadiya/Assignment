package com.example.signup_form.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.signup_form.R
import com.example.signup_form.databinding.FragmentSignInBinding
import java.util.regex.Pattern

class SignInFragment : Fragment() {

    lateinit var binding: FragmentSignInBinding

   /* private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+"*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState:Bundle?
    ): View?{
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(layoutInflater)
        binding.btnSignin.setOnClickListener{
            setListner()
            if (!validEmail()) {
               // binding.etEmail.text.toString().isEmpty()
               Toast.makeText(requireActivity(), "if", Toast.LENGTH_SHORT).show()
            }

            else if(!validPass()) {
                //validPass()
                binding.etPassword.text.toString().isEmpty()
                Toast.makeText(requireActivity(), "else if", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireActivity(), "else", Toast.LENGTH_SHORT).show()
            }

        }
        return (binding.root)
    }

    private fun validPass(): Boolean {
        var password = binding.etPassword.text.toString().trim()

        var regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
        if (password.isEmpty()){
            binding.tvPassword.error = "Enter Password"
            binding.etPassword.requestFocus()
            return false
        } else if (password.equals(regex)) {
            binding.tvPassword.error = "invalid password"
            return false

        } else {
            binding.tvPassword.isErrorEnabled = false
            return true

        }

    }

    private fun validEmail(): Boolean {

        var email = binding.etEmail.text.toString().trim()
        val metch = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if(email.isEmpty()){
            binding.tvEmail.error = "Email Address"
            Toast.makeText(requireActivity(), " if", Toast.LENGTH_SHORT).show()
        }
        else if (!email.equals(metch)){
            binding.tvEmail.error = "Email Addresss"
            Toast.makeText(requireActivity(), "else if email", Toast.LENGTH_SHORT).show()
        }else{
            binding.etEmail.requestFocus()
            binding.tvEmail.isErrorEnabled = false
           // return true
        }
        return false
    }

    private fun setListner(){
        Toast.makeText(requireActivity(), "set listner", Toast.LENGTH_SHORT).show()
        var email = binding.etEmail.addTextChangedListener(TextFieldValidation(binding.etEmail))
        var pass =  binding.etPassword.addTextChangedListener(TextFieldValidation(binding.etPassword))
        //var cpass = binding.etCpassword.addTextChangedListener(TextFieldValidation(binding.etCpassword))

    }

    inner class TextFieldValidation(var view: View) : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            // binding.etCpassword.text=null

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            when (view.id) {
                R.id.et_Email -> {
                    if(!validEmail()){
                       binding.tvEmail.error = "Email Addresss"
                    }
                    Toast.makeText(requireActivity(), "id valo code", Toast.LENGTH_SHORT).show()
                }
                R.id.et_password -> {
                    validPass()
                    Toast.makeText(requireActivity(), "id valo code", Toast.LENGTH_SHORT).show()
                }


            }

        }


        override fun afterTextChanged(p0: Editable?) {
            // var conform=binding.etCpassword.text.toString()
            // binding.etCpassword.text=null
        }
    }
}






