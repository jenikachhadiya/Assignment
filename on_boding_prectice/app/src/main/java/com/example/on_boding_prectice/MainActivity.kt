package com.example.on_boding_prectice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.example.on_boding_prectice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var autoscroll = mutableListOf<item>()
    lateinit var oadaptor: onBodingAdaptor

    var curruntindex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addadata()

        binding.btnNext.setOnClickListener {
            if (curruntindex != oadaptor.count - 1) {
                curruntindex++
                binding.viewPager.currentItem = curruntindex
            } else {

            }

        }
        oadaptor = onBodingAdaptor(this, autoscroll)
        binding.viewPager.adapter = oadaptor
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {


            }

            override fun onPageSelected(position: Int) {
                curruntindex = position
                if (curruntindex == oadaptor.count - 1) {
                    binding.btnNext.setText("Finish")
                } else {
                    binding.btnNext.setText("Next")
                }

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })


    }

    private fun addadata() {
        autoscroll.add(
            item(
                1,
                "Step 1",
                "Sign Up",
                R.drawable.firstpage,
                "A signup page (also known as a registration page) enables users and organizations to independently register and gain access to your system"
            )
        )
        autoscroll.add(
            item(
                2,
                "Step 2",
                "Match with Grents ",
                R.drawable.firstpage,
                "A signup page (also known as a registration page) enables users and organizations to independently register and gain access to your system"
            )
        )
        autoscroll.add(
            item(
                3,
                "Step 3",
                "Select And Apply",
                R.drawable.firstpage,
                "A signup page (also known as a registration page) enables users and organizations to independently register and gain access to your system"
            )
        )

    }

    fun updateindicati() {

        binding.layoutDots.removeAllViews()

        //setview in margin
        var lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        lp.setMargins(8, 0, 0, 0)

        for (i in autoscroll.indices) {
            var view = ImageView(applicationContext)
               view.layoutParams =lp
            if(i==curruntindex){
                view.setImageResource(R.drawable.gradiant_endicater)

            }else{
                view.setImageResource(R.drawable.gradiant_endicater_inacti)
            }
            //layout ma Dainamical Image view adding
            binding.layoutDots.addView(view)



        }



    }
}