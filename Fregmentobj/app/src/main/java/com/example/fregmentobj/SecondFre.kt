package com.example.fregmentobj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fregmentobj.databinding.FragmentFirstFreBinding
import com.example.fregmentobj.databinding.FragmentSecondFreBinding

class SecondFre : Fragment() {

private lateinit var binding: FragmentSecondFreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondFreBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            /*var name = it.getString("Name")
            var email = it.getString("Email")
            var age = it.getString("Age")
            binding.tvResult.text = "Name = $name \n email = $email \n Age =$age"
             */


            var result = it.getParcelable<objPass>("OBJ") as objPass
             binding.tvResult.text ="${result.name} \n ${result.email} \n${result.age}"

        }

    }


}