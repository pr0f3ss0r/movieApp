package com.example.moviedatabaseapp.data.repository.movie.datasourceimpl

import com.example.moviedatabaseapp.data.api.MovieService
import com.example.moviedatabaseapp.data.model.artist.ArtistList
import com.example.moviedatabaseapp.data.model.movie.MovieList
import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val movieService: MovieService,
    private val apiKey:String):
    ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return movieService.getPopularArtists(apiKey)
    }
}