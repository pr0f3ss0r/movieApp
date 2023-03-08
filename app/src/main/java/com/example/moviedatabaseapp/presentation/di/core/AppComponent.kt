package com.example.moviedatabaseapp.presentation.di.core

import com.example.moviedatabaseapp.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabaseapp.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabaseapp.presentation.di.tvshow.TvShowSubcomponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DataBaseModule::class,
    LocalDataModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,


])
interface AppComponent {
    fun movieSubcomponent(): MovieSubcomponent.Factory
    fun artistSubcomponent(): ArtistSubcomponent.Factory
    fun tvShowSubcomponent(): TvShowSubcomponent.Factory
}