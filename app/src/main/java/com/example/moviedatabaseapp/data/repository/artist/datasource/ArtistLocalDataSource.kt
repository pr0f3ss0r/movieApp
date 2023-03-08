package com.example.moviedatabaseapp.data.repository.movie.datasource

import com.example.moviedatabaseapp.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(movies:List<Artist>)
    suspend fun clearAll()
}