package com.example.moviedatabaseapp.data.repository.tvshow.datasource

import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}