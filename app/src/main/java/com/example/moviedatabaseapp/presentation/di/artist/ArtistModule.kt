package com.example.moviedatabaseapp.presentation.di.artist

import com.example.moviedatabaseapp.domain.usecases.GetArtistsUseCase
import com.example.moviedatabaseapp.domain.usecases.GetTvShowsUseCase
import com.example.moviedatabaseapp.domain.usecases.UpdateArtistsUseCase
import com.example.moviedatabaseapp.presentation.artist.ArtistViewModel
import com.example.moviedatabaseapp.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase, updateArtistsUseCase)
    }
}