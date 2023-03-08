package com.example.moviedatabaseapp.domain.usecases

import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository){
    suspend fun execute(): List<Movie>? = movieRepository.getMovies()
}