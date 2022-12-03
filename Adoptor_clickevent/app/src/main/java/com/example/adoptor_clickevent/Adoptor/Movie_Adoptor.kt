package com.example.adoptor_clickevent.Adoptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptor_clickevent.Activitys.Navigrat
import com.example.adoptor_clickevent.Classes.Movie
import com.example.adoptor_clickevent.Classes.OnClickLisener
import com.example.adoptor_clickevent.databinding.MovieLayoutBinding

class Movie_Adoptor(var context: Context, var movielist: MutableList<Movie>) :
    RecyclerView.Adapter<Movie_Adoptor.myviewholder>() {
    private lateinit var binding: MovieLayoutBinding

    private lateinit var clickeevent: OnClickLisener

    class myviewholder(var bind: MovieLayoutBinding) : RecyclerView.ViewHolder(bind.root) {


    }

    fun setonclicklistener(clickLisener: OnClickLisener) {
        this.clickeevent = clickLisener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        binding = MovieLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return myviewholder(binding)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        var movie = movielist[position]
        holder.bind.ivMovie.setImageResource(movie.image)
        holder.bind.tvTital.text = movie.name
        holder.bind.rbRat.rating = movie.rating
        holder.bind.tvYer.text = "${movie.year}"
        holder.bind.tvDes.text = movie.Des

        //adoptor class clicke event

        holder.bind.linear.setOnClickListener {
            clickeevent.OnMovieCardClick(movie, position)


/*
            var intent = Intent(context,Navigrat::class.java)
            intent.putExtra("Movie",movie)
            context.startActivity(intent)*/


        }
        //image clike events
        holder.bind.ivMovie.setOnClickListener {
            clickeevent.OnImgClick(movie)

        }

    }

    override fun getItemCount(): Int {
        return movielist.size
    }


}