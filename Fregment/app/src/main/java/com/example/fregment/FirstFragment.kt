package com.example.fregment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fregment.databinding.FragmentFirstBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FirstFragment : Fragment() {
    lateinit var binding : FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {



             var name = binding.etName.text.toString().trim()
            var mess = binding.etMess.text.toString().trim()

            var bundle = Bundle()
            bundle.putString("Name",name)
            bundle.putString("Mess",mess)

            // navigrate to second fragment..

            var fragment = SecondFragment()
            fragment.arguments = bundle

            var manager: FragmentManager = requireActivity().supportFragmentManager
            var transaction: FragmentTransaction = manager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()



/*

                requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                    .addToBackStack(null)
                .commit()
*/


        }

    }


}