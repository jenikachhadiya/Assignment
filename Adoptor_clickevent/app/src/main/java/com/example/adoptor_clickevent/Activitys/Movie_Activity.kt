package com.example.adoptor_clickevent.Activitys

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adoptor_clickevent.Adoptor.Movie_Adoptor
import com.example.adoptor_clickevent.Classes.Movie
import com.example.adoptor_clickevent.Classes.OnClickLisener
import com.example.adoptor_clickevent.R
import com.example.adoptor_clickevent.databinding.ActivityMovieBinding
import com.example.adoptor_clickevent.databinding.CustomDailogBinding

class Movie_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    private var movielist = mutableListOf<Movie>()

    lateinit var madoptor: Movie_Adoptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adddata()

        madoptor = Movie_Adoptor(this,movielist)

        var manager = LinearLayoutManager(applicationContext)
        binding.recView.layoutManager = manager

        binding.recView.adapter = madoptor

        madoptor.setonclicklistener(object : OnClickLisener {

            override fun OnMovieCardClick(movie: Movie, pas: Int) {

                  var intent = Intent(applicationContext,Navigrat::class.java)
                  intent.putExtra("Movie",movie)
                  startActivity(intent)
            }

            override fun OnImgClick(movie: Movie) {

                setonImg(movie)


            }
        })



    }

    private fun setonImg(movie: Movie) {
        var bind = CustomDailogBinding.inflate(layoutInflater)
        var builder = AlertDialog.Builder(this)
        builder.setView(bind.root)

        bind.image.setImageResource(movie.image)
        var Dialog = builder.create()

        Dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            Dialog.show()



    }

    private fun adddata() {
        movielist.apply {
            this.add(Movie(1,"Thor The Dark World",4.5f,"Action ,Horoarr ,Thrild",2009,R.drawable.m1))
            this.add(Movie(2,"The Secrets of DumbulDoor",2.5f,"Romence ,Horoarr ,Thrild",2015,R.drawable.m2))
            this.add(Movie(3,"Blake Faster Wakenda Forevers",3.4f,"Horoarr ,Thrild",2011,R.drawable.m3))
            this.add(Movie(4,"Avengers Endgame",4.1f,"Action ,Horoarr ,Thrild",2019,R.drawable.m4))
            this.add(Movie(5,"Jungle Crusies",2.3f,"Action ,Romance ,Thrild",2002,R.drawable.m5))



        }
    }
}