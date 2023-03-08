package com.example.moviedatabaseapp.data.repository.movie.datasource

import com.example.moviedatabaseapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}