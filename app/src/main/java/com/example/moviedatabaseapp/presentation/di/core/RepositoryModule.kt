package com.example.moviedatabaseapp.presentation.di.core

import com.example.moviedatabaseapp.data.repository.TvShowRepositoryImpl
import com.example.moviedatabaseapp.data.repository.artist.ArtistRepositoryImpl
import com.example.moviedatabaseapp.data.repository.movie.MovieRepositoryImpl
import com.example.moviedatabaseapp.data.repository.movie.datasource.*
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviedatabaseapp.domain.repository.ArtistRepository
import com.example.moviedatabaseapp.domain.repository.MovieRepository
import com.example.moviedatabaseapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
       tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}