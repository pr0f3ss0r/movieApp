package com.example.moviedatabaseapp.data.repository.movie.datasource

import com.example.moviedatabaseapp.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}