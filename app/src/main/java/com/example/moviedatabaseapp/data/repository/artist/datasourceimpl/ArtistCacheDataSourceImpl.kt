package com.example.moviedatabaseapp.data.repository.movie.datasourceimpl

import com.example.moviedatabaseapp.data.model.artist.Artist
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl(): ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}