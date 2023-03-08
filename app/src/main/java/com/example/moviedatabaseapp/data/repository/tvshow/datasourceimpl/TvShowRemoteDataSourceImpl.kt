package com.example.moviedatabaseapp.data.repository.tvshow.datasourceimpl

import com.example.moviedatabaseapp.data.api.MovieService
import com.example.moviedatabaseapp.data.model.movie.MovieList
import com.example.moviedatabaseapp.data.model.tvshow.TvShowList
import com.example.moviedatabaseapp.data.repository.movie.datasource.ArtistRemoteDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tvShowService: MovieService,
    private val apiKey:String):
    TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tvShowService.getPopularTvShows(apiKey)
    }

}