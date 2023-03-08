package com.example.moviedatabaseapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedatabaseapp.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(movies: List<TvShow>)

    @Query("DELETE FROM TvShow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM TvShow")
    suspend fun getTvShows():List<TvShow>
}