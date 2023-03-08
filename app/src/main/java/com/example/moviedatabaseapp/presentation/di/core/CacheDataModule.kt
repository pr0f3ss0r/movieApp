package com.example.moviedatabaseapp.presentation.di.core

import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistCacheDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasource.MovieCacheDataSource
import com.example.moviedatabaseapp.data.repository.movie.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.moviedatabaseapp.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}