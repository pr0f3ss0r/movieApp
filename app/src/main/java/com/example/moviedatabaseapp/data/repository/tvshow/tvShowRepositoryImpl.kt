package com.example.moviedatabaseapp.data.repository

import android.util.Log
import com.example.moviedatabaseapp.data.model.artist.Artist
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.model.movie.MovieList
import com.example.moviedatabaseapp.data.model.tvshow.TvShow
import com.example.moviedatabaseapp.data.model.tvshow.TvShowList
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.moviedatabaseapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.moviedatabaseapp.domain.repository.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows: List<TvShow> = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>

        try {
            val response: Response<TvShowList> = tvShowRemoteDataSource.getTvShows()
            val body: TvShowList? = response.body()
            if(body != null){
                tvShowList = body.tvShows
            }
        }catch (e:Exception){
            Log.e("getMoviesFromAPI:", e.message.toString(), )
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (e:Exception){
            Log.e("getTvShowsFromDB:", e.message.toString(), )
        }
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (e:Exception){
            Log.e("getTvShowsFromCache:", e.message.toString(), )
        }
        if(tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }

}