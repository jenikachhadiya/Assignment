package com.example.adopter.Adoptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.adopter.Modal.Movie
import com.example.adopter.databinding.ItemLayoutBinding
import com.example.adopter.databinding.MovieLayoutBinding

class MovieAdoptor (var context: Context,var Movielist : MutableList<Movie>):BaseAdapter(){

    private lateinit var binding: MovieLayoutBinding

    override fun getCount(): Int {
     return  Movielist.size
    }

    override fun getItem(pos: Int): Any {
       return  Movielist[pos]
    }

    override fun getItemId(pos: Int): Long{
      return  pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {

        binding = MovieLayoutBinding.inflate(LayoutInflater.from(context),parent,false)

        var movie = Movielist[pos]
        binding.ivMovie.setImageResource(movie.image)
        binding.tvTital.text = movie.name
        binding.rbRat.rating = movie.rating
        binding.tvDes.text =movie.Des
        binding.tvYer.text="${movie.year}"


       return binding.root
    }


}