package com.example.moviedatabaseapp.data.repository.tvshow.datasource

import com.example.moviedatabaseapp.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(movies:List<TvShow>)
    suspend fun clearAll()
}