package com.example.moviedatabaseapp.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.domain.usecases.GetMoviesUseCase
import com.example.moviedatabaseapp.domain.usecases.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }
    fun updateMovies(): LiveData<List<Movie>?> = liveData {
        val updateList: List<Movie>? = updateMoviesUseCase.execute()
        emit(updateList)
    }
}