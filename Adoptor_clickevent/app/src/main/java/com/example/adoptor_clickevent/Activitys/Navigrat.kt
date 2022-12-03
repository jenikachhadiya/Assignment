
package com.example.adoptor_clickevent.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.example.adoptor_clickevent.Classes.Movie
import com.example.adoptor_clickevent.R
import com.example.adoptor_clickevent.databinding.ActivityNavigratBinding

class Navigrat : AppCompatActivity() {
    lateinit var binding: ActivityNavigratBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigratBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //get value using binding

        var movie:Movie = intent.getParcelableExtra<Movie>("Movie") as Movie
       movie?.let {
        binding.ivMovi.setImageResource(it.image)
           binding.tvNamee.text = it.name
           binding.rbRatee.rating = it.rating
           binding.tvDescc.text = it.Des
           binding.tvYerr.text ="${it.year}"
       }




    }
}