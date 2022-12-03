package com.example.onbodingscreen.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.onbodingscreen.Adoptor.OnBoding_Adoptor
import com.example.onbodingscreen.R
import com.example.onbodingscreen.databinding.ActivityOnBodingScreen2Binding
import com.example.onbodingscreen.modal.item

class OnBodingScreen : AppCompatActivity() {
    private lateinit var binding: ActivityOnBodingScreen2Binding
    private var itemlist = mutableListOf<item>()
    private var currentIndex = 0

    private lateinit var mAdoptor :OnBoding_Adoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBodingScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        parepardata()
        //btn_next nu clicke event hendling
        binding.btnNext.setOnClickListener {
            if(currentIndex!=mAdoptor.count-1){
                currentIndex++
                binding.viewPager.currentItem = currentIndex
            }else{
                //finish no clicke evnet is here to handaling it
                Toast.makeText(applicationContext, "Navigrat to secand activity ", Toast.LENGTH_SHORT).show()
            }

        }

        //passing data adoptor to using constructor
        mAdoptor = OnBoding_Adoptor(this,itemlist)
        binding.viewPager.adapter = mAdoptor

        updateIndicator(currentIndex)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ){

            }

            override fun onPageSelected(position: Int) {
             currentIndex = position
                if (currentIndex==mAdoptor.count-1){
                    binding.btnNext.text = "Finish"
                }else{
                    binding.btnNext.text = "Next"
                }

                updateIndicator(currentIndex)
               //Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {

            }


        })

    }

    private fun parepardata() {
        itemlist.add(item(1,"Step 1","Sign Up",R.drawable.firstpage,"A signup page (also known as a registration page) enables users and organizations to independently register and gain access to your system"))
        itemlist.add(item(2,"Step 2","Match with Grents ",R.drawable.firstpage,"A signup page (also known as a registration page) enables users and organizations to independently register and gain access to your system"))
        itemlist.add(item(3,"Step 3","Select And Apply",R.drawable.firstpage,"A signup page (also known as a registration page) enables users and organizations to independently register and gain access to your system"))
    }
    private  fun updateIndicator(index:Int){

        //anathi dark aglna view remove thai jase
        binding.layoutDots.removeAllViews()


        //set layout in margin Top,left,Right,Bottam
        var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(8,0,0,0)

        for (i in itemlist.indices){
            //view in set image
            var view = ImageView(applicationContext)
            view.layoutParams = lp
            if(i==currentIndex){
                view.setImageResource(R.drawable.gradiant_endicater)

            }else{
                view.setImageResource(R.drawable.gradiant_endicater_inacti)
            }
            //layout ma Dainamical Image view adding
            binding.layoutDots.addView(view)

        }


    }
}