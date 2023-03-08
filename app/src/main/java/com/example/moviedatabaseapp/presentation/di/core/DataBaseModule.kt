package com.example.moviedatabaseapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.moviedatabaseapp.data.db.ArtistDao
import com.example.moviedatabaseapp.data.db.MovieDao
import com.example.moviedatabaseapp.data.db.MoviesDatabase
import com.example.moviedatabaseapp.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): MoviesDatabase{
        return Room.databaseBuilder(context, MoviesDatabase::class.java,
            "moviesClient")
            .build()
    }
    @Singleton
    @Provides
    fun provideMovieDao(moviesDatabase: MoviesDatabase): MovieDao{
        return moviesDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideTvShowDao(moviesDatabase: MoviesDatabase): TvShowDao{
        return moviesDatabase.tvShowDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(moviesDatabase: MoviesDatabase): ArtistDao{
        return moviesDatabase.artistDao()
    }

}