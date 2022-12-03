package com.example.vartical_viewpager2.Activitys

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.vartical_viewpager2.Adoptor.vartical_adoptor
import com.example.vartical_viewpager2.Modal.vartical_swipe
import com.example.vartical_viewpager2.R
import com.example.vartical_viewpager2.databinding.ActivityVarticalSwipeBinding

class vartical_Activity : AppCompatActivity() {
    lateinit var binding : ActivityVarticalSwipeBinding

    var varlist = mutableListOf<vartical_swipe>()
   private lateinit var Vadoptor : vartical_adoptor
   private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVarticalSwipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addData()

        //set on datials in adoptor
        Vadoptor = vartical_adoptor(this,varlist)
        binding.viewPager2.adapter = Vadoptor
        binding.viewPager2.setCurrentItem(0,false)


        //get position geting
        updateIndicaton(currentIndex)






        fun onPageselected(position: Int){
            currentIndex =position
            updateIndicaton(currentIndex)
            Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()
        }






    }



    private fun addData() {
        varlist.add(vartical_swipe(1,R.drawable.onboding1,"Businnesss Planing","More and More third World Science and technology Planing and education people are heading for more prospore countines seelings higers wagerts"))
        varlist.add(vartical_swipe(2,R.drawable.onboding2,"Businnesss Planing","More and More third World Science and technology Planing and education people are heading for more prospore countines seelings higers wagerts"))
        varlist.add(vartical_swipe(3,R.drawable.onboding3,"Businnesss Planing","More and More third World Science and technology Planing and education people are heading for more prospore countines seelings higers wagerts"))

    }
    private fun updateIndicaton(index:Int) {
        //remove all layout indicator
        binding.linear.removeAllViews()


        var lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        lp.setMargins(4,5,0,0)

        for (i in varlist.indices){

            //view in set image

            var view = ImageView(applicationContext)
            view.layoutParams = lp
            if (i==currentIndex){
                 view.setImageResource(R.drawable.activted_inducator)
            }else{
                view.setImageResource(R.drawable.inactivted_inducator)
            }
            //layout ma dainamicaliy img set up
            binding.linear.addView(view)



        }



    }
}


