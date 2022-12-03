package com.example.adoptor2.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptor2.Adoptors.Movie_Adoptor
import com.example.adoptor2.Modal.Movie
import com.example.adoptor2.Modal.OnItemClickLitener
import com.example.adoptor2.R
import com.example.adoptor2.databinding.ActivityRecycleBinding

class Recycle_Activity : AppCompatActivity() {
    lateinit var binding: ActivityRecycleBinding
    private var movielist = mutableListOf<Movie>()
    lateinit var movieAdoptor: Movie_Adoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleBinding.inflate(layoutInflater)


        setContentView(binding.root)



        movieAdoptor = Movie_Adoptor(this,movielist)
        var Maneger = GridLayoutManager(applicationContext,2,LinearLayoutManager.HORIZONTAL,false) //defalt vartical hoy che
        binding.recView.layoutManager = Maneger
        binding.recView.adapter = movieAdoptor




        movieAdoptor.setonItemclickListner(object : OnItemClickLitener {
            override fun OnCardClick(movie: Movie, pos: Int) {



            }

            override fun OnImageClick(movie: Movie) {

            }


        })




    }
}