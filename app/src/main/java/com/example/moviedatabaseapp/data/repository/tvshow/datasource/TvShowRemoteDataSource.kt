package com.example.moviedatabaseapp.data.repository.tvshow.datasource

import com.example.moviedatabaseapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TvShowList>
}