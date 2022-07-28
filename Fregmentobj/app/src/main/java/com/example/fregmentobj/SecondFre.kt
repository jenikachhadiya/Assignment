package com.example.fregmentobj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fregmentobj.databinding.FragmentFirstFreBinding
import com.example.fregmentobj.databinding.FragmentSecondFreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFre.newInstance] factory method to
 * create an instance of this fragment.
 */
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