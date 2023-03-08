package com.example.moviedatabaseapp.presentation.di

import com.example.moviedatabaseapp.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabaseapp.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabaseapp.presentation.di.tvshow.TvShowSubcomponent


interface Injector {
    fun createMovieSubcomponent(): MovieSubcomponent
    fun createArtistSubcomponent(): ArtistSubcomponent
    fun createTvShowSubcomponent(): TvShowSubcomponent
}