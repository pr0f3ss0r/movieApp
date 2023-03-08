package com.example.moviedatabaseapp.presentation.di.movie

import com.example.moviedatabaseapp.domain.usecases.*
import com.example.moviedatabaseapp.presentation.artist.ArtistViewModel
import com.example.moviedatabaseapp.presentation.artist.ArtistViewModelFactory
import com.example.moviedatabaseapp.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}