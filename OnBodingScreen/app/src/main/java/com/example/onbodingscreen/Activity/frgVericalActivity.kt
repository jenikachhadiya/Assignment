package com.example.onbodingscreen.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.onbodingscreen.Adoptor.OnBodingVarticalAdapter
import com.example.onbodingscreen.Adoptor.auto_Adoptor
import com.example.onbodingscreen.R
import com.example.onbodingscreen.databinding.ActivityFrgVericalBinding
import com.example.onbodingscreen.modal.autoscroll

class frgVericalActivity : FragmentActivity() {
    var autolist = mutableListOf<autoscroll>()
    // lateinit var autoAdoptor: auto_Adoptor
    lateinit var autoAdoptor: OnBodingVarticalAdapter
    lateinit var binding: ActivityFrgVericalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrgVericalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        addData()
        autoAdoptor = OnBodingVarticalAdapter(autolist, this)
        ///adoptor = auto_Adoptor(this,autolist)
        //binding.viewPager2.orientation=
        binding.viewData.adapter = autoAdoptor
        binding.viewData.setCurrentItem(0, true)
    }

    private fun addData() {
        autolist.add(autoscroll(1, R.drawable.ic_launcher_foreground))
        autolist.add(autoscroll(1, R.drawable.ic_launcher_background))
        autolist.add(autoscroll(1, R.drawable.ic_launcher_foreground))
        autolist.add(autoscroll(1, R.drawable.ic_launcher_background))
        autolist.add(autoscroll(1, R.drawable.ic_launcher_background))
        autolist.add(autoscroll(1, R.drawable.img))
    }
}