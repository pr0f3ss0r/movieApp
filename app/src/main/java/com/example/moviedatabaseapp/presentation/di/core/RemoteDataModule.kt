package com.example.moviedatabaseapp.presentation.di.core

import com.example.moviedatabaseapp.data.api.MovieService
import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistRemoteDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.moviedatabaseapp.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieService: MovieService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(movieService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(movieService: MovieService): ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(movieService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(movieService: MovieService): TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(movieService, apiKey)
    }
}