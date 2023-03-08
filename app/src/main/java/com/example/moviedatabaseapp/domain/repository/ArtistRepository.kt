package com.example.moviedatabaseapp.domain.repository

import androidx.room.Update
import com.example.moviedatabaseapp.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}