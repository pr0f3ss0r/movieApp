package com.example.moviedatabaseapp.data.db

import android.provider.MediaStore.Audio.Artists
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedatabaseapp.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

    @Query("DELETE FROM Artist")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM Artist")
    suspend fun getArtists():List<Artist>
}