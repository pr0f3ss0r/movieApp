package com.example.moviedatabaseapp.presentation.di.core

import com.example.moviedatabaseapp.data.db.ArtistDao
import com.example.moviedatabaseapp.data.db.MovieDao
import com.example.moviedatabaseapp.data.db.TvShowDao
import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistLocalDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.moviedatabaseapp.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}