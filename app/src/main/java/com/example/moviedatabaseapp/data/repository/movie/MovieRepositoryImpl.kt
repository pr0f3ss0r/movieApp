package com.example.moviedatabaseapp.data.repository.movie

import android.util.Log
import android.widget.Toast
import com.example.moviedatabaseapp.data.model.movie.Movie
import com.example.moviedatabaseapp.data.model.movie.MovieList
import com.example.moviedatabaseapp.data.repository.movie.datasource.*
import com.example.moviedatabaseapp.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies: List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList:List<Movie>

        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if(body != null){
                movieList = body.movies
            }
        }catch (e:Exception){
            Log.e("getMoviesFromAPI:", e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (e:Exception){
            Log.e("getMoviesFromDB:", e.message.toString())
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{
        lateinit var movieList:List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e:Exception){
            Log.e("getMoviesFromCache:", e.message.toString(), )
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}