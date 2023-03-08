package com.example.moviedatabaseapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM Movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM Movie")
    suspend fun getMovies():List<Movie>
}