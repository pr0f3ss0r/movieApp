package com.example.moviedatabaseapp.domain.repository

import androidx.room.Update
import com.example.moviedatabaseapp.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}