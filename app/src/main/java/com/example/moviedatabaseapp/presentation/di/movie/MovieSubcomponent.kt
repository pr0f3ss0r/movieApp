package com.example.moviedatabaseapp.presentation.di.movie

import com.example.moviedatabaseapp.presentation.artist.ArtistActivity
import com.example.moviedatabaseapp.presentation.movie.MovieActivity
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubcomponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubcomponent
    }
}