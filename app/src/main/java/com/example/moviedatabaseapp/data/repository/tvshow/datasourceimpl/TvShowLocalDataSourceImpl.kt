package com.example.moviedatabaseapp.data.repository.tvshow.datasourceimpl

import com.example.moviedatabaseapp.data.db.MovieDao
import com.example.moviedatabaseapp.data.db.TvShowDao
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.model.tvshow.TvShow
import com.example.moviedatabaseapp.data.repository.movie.datasource.MovieLocalDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}