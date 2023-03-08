package com.example.moviedatabaseapp.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.databinding.ListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MyViewHolder>(){
    private val movieList = ArrayList<Movie>()
    fun setlist(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(
            layoutInflater,  parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

}

class MyViewHolder(private val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.titleTextView.text = movie.title
            binding.descTextView.text = movie.overview
            val posterURL = "https://image.tmdb.org/t/p/original/"+movie.posterPath
            Glide.with(binding.photoImageView.context)
                .load(posterURL)
                .into(binding.photoImageView)
        }
    }

