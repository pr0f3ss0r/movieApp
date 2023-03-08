package com.example.moviedatabaseapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviedatabaseapp.data.model.artist.Artist
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.model.tvshow.Converters
import com.example.moviedatabaseapp.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class],
    version = 1, exportSchema = false)

@TypeConverters(Converters::class)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}