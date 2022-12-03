package com.example.signup_form.Adaptor

import androidx.core.os.persistableBundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.signup_form.fragment.SignInFragment
import com.example.signup_form.fragment.SignupFragment

class viewpager_adoptor(var fragment: FragmentManager,var tabcount:Int):FragmentPagerAdapter(fragment) {

   // lateinit var sighupFragment: sighupFragment
   //lateinit var signinFragment: signinFragment
    override fun getCount(): Int {
        return tabcount

    }

    override fun getItem(position: Int): Fragment {

        return when(position)
        {
            0->SignInFragment()
            1->SignupFragment()
            else->SignInFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if(position==0){
            "SignIn"
        }else{
            "SignUp"
        }
    }
}