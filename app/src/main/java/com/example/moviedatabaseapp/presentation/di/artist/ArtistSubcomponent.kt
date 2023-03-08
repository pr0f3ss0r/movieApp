package com.example.moviedatabaseapp.presentation.di.artist

import com.example.moviedatabaseapp.presentation.artist.ArtistActivity
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubcomponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubcomponent
    }
}