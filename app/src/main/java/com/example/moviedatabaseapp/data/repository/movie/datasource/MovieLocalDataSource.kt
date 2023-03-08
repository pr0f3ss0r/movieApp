package com.example.moviedatabaseapp.data.repository.movie.datasource

import com.example.moviedatabaseapp.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}