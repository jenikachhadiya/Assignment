package com.example.fregmentobj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fregmentobj.databinding.FragmentFirstFreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFre.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFre : Fragment() {
   private lateinit var binding: FragmentFirstFreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstFreBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnButton.setOnClickListener {
            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var age = binding.etAge.text.toString().toInt()


            var bundle = Bundle()
           /* bundle.putString("Name",name)
            bundle.putString("Email",email)
            bundle.putInt("Age",age)

            */

            var obj = objPass(name,email,age)
            bundle.putParcelable("OBJ",obj)


            //navigration one fregment to secod fragemnt
            var fregment = SecondFre()
            fregment.arguments = bundle

                requireActivity()
                    .supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fregment_contanar,fregment)
                    .addToBackStack(null)
                    .commit()

        }
    }

}