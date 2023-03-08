package com.example.moviedatabaseapp.data.repository.movie.datasourceimpl

import com.example.moviedatabaseapp.data.api.MovieService
import com.example.moviedatabaseapp.data.model.movie.MovieList
import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistRemoteDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val movieService: MovieService,
    private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return movieService.getPopularMovies(apiKey)
    }
}