package com.example.moviedatabaseapp.presentation.di.tvshow

import com.example.moviedatabaseapp.presentation.artist.ArtistActivity
import com.example.moviedatabaseapp.presentation.tvshow.TvShowActivity
import dagger.Subcomponent


@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubcomponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubcomponent
    }
}