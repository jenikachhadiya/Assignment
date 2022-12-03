package com.example.fregment

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.os.Message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fregment.databinding.FragmentThirdFregmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFregment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFregment : Fragment() {

    private lateinit var binding: FragmentThirdFregmentBinding
    private lateinit var communicater: communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdFregmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicater = context as communicator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding .btnNext.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var message = binding.etMess.text.toString().trim()

            communicater.sendValue(name,message)

        }

    }
   interface communicator{
    fun sendValue(name:String,message: String)


}

}