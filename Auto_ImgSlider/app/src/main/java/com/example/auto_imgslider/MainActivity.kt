package com.example.auto_imgslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.auto_imgslider.Adoptors.auto_slider_adoptor
import com.example.auto_imgslider.Modal.img
import com.example.auto_imgslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var imglist = mutableListOf<img>()
    lateinit var Iadoptor :auto_slider_adoptor
    var currentIndex = 0
    var time = Thread.sleep(2000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        parparData()

       /*Thread(Runnable {

            Thread.sleep(2000)

        }).start()*/

        //set adoptor in imglist
        Iadoptor = auto_slider_adoptor(this,imglist)

        //set view page in adoptor
        binding.viewPage.adapter = Iadoptor


       //img list [currentIndex]
        var img = imglist[currentIndex]






        binding.viewPage.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ){

            }

            override fun onPageSelected(position: Int) {
               currentIndex = position



                //Toast.makeText(applicationContext, "$position", Toast.LENGTH_SHORT).show()

            }

            override fun onPageScrollStateChanged(state: Int){

            }


        })



    }

    private fun parparData(){
        imglist.add(img(1,R.drawable.fp))
        imglist.add(img(2,R.drawable.second))
        imglist.add(img(3,R.drawable.three))
        imglist.add(img(4,R.drawable.fourth))
        imglist.add(img(5,R.drawable.five))
    }

}