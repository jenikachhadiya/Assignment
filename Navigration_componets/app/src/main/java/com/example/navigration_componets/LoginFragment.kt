package com.example.navigration_componets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigration_componets.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navicantrollar =
            Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
        binding.btnNH.setOnClickListener {
            navicantrollar.navigate(R.id.action_loginFragment_to_homeFragment)


        }
        binding.btnNR.setOnClickListener {
            navicantrollar.navigate(R.id.action_loginFragment_to_ragisterFragment)
        }
    }

}