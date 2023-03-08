package com.example.moviedatabaseapp.domain.repository

import androidx.room.Update
import com.example.moviedatabaseapp.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}