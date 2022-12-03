package com.example.adopter.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.adopter.Adoptor.MovieAdoptor

import com.example.adopter.Modal.Movie
import com.example.adopter.R
import com.example.adopter.databinding.ActivityMovieBinding
import com.example.adopter.databinding.CustomDialogBinding

class Movie_Activity : AppCompatActivity() {
   lateinit var binding: ActivityMovieBinding
    private var Movielist = mutableListOf<Movie>()
    lateinit var adoptor: MovieAdoptor

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mothod adding mutable list
        moviedata()
            //set data
        adoptor = MovieAdoptor(this,Movielist)
        //adoptor to adoptor view
        binding.mlistView.adapter = adoptor


        //clicke event

        binding.mlistView.setOnItemClickListener { adapterView, view, i, l ->

            var movie = Movielist[i]
            //show diylog
            //and create dialog
            var bind = CustomDialogBinding.inflate(layoutInflater)
            var builder = AlertDialog.Builder(this)
                .setView(bind.root)

            //dialod create thy and show thy a vache data set thy che

            val dialog = builder.create()

            // value get thay che
            bind.ivMov.setImageResource(movie.image)
            bind.tvName.text=movie.name
            bind.rbRate.rating = movie.rating
            bind.tvYer.text = "${movie.year}"
            bind.tvDesc.text = movie.Des

                dialog.show()

            //Toast.makeText(applicationContext, "${movie.name}", Toast.LENGTH_SHORT).show()

        }




    }

    private fun moviedata() {

        Movielist.apply {
            this.add(Movie(1,"Thor The Dark World",4.5f,"Action ,Horoarr ,Thrild",2009,R.drawable.m1))
            this.add(Movie(2,"The Secrets of DumbulDoor",2.5f,"Romence ,Horoarr ,Thrild",2015,R.drawable.m2))
            this.add(Movie(3,"Blake Faster Wakenda Forevers",3.4f,"Horoarr ,Thrild",2011,R.drawable.m3))
            this.add(Movie(4,"Avengers Endgame",4.1f,"Action ,Horoarr ,Thrild",2019,R.drawable.m4))
            this.add(Movie(5,"Jungle Crusies",2.3f,"Action ,Romance ,Thrild",2002,R.drawable.m5))



        }
    }

}