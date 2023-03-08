package com.example.moviedatabaseapp.presentation

import android.app.Application
import com.example.moviedatabaseapp.BuildConfig
import com.example.moviedatabaseapp.presentation.di.Injector
import com.example.moviedatabaseapp.presentation.di.artist.ArtistSubcomponent
import com.example.moviedatabaseapp.presentation.di.core.*
import com.example.moviedatabaseapp.presentation.di.movie.MovieSubcomponent
import com.example.moviedatabaseapp.presentation.di.tvshow.TvShowSubcomponent

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubcomponent(): MovieSubcomponent {
        return appComponent.movieSubcomponent().create()
    }

    override fun createArtistSubcomponent(): ArtistSubcomponent {
        return appComponent.artistSubcomponent().create()
    }

    override fun createTvShowSubcomponent(): TvShowSubcomponent {
        return appComponent.tvShowSubcomponent().create()
    }
}