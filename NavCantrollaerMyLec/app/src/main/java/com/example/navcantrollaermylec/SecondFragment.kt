package com.example.navcantrollaermylec

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {

    val args:SecondFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tvResult  =view.findViewById<TextView>(R.id.tv_data)
        tvResult.text = """
            name = ${args.name}
            email = ${args.email}
            age = ${args.age}
        """.trimIndent()


        var navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)


        view.findViewById<Button>(R.id.btn_sec).setOnClickListener {

            navController.navigate(R.id.action_secondFragment_to_firstFragment2)

        }
        view.findViewById<Button>(R.id.btn_third).setOnClickListener {

            navController.navigate(R.id.action_secondFragment_to_thirdFragment2)

        }
    }


}