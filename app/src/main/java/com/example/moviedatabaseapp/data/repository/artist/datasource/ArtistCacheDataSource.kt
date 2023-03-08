package com.example.moviedatabaseapp.data.repository.movie.datasource

import com.example.moviedatabaseapp.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(movies:List<Artist>)
}