package com.example.moviedatabaseapp.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.model.tvshow.TvShow
import com.example.moviedatabaseapp.data.model.tvshow.TvShowList
import com.example.moviedatabaseapp.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<MyViewHolder>(){
    private val tvShowList = ArrayList<TvShow>()

    fun setlist(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = ListItemBinding.inflate(
            layoutInflater,  parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

}

class MyViewHolder(private val binding: ListItemBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(tvshow:TvShow){
            binding.titleTextView.text = tvshow.name
            binding.descTextView.text = tvshow.firstAirDate
            val posterURL = "https://image.tmdb.org/t/p/original/"+tvshow.posterPath
            Glide.with(binding.photoImageView.context)
                .load(posterURL)
                .into(binding.photoImageView)
        }
    }

