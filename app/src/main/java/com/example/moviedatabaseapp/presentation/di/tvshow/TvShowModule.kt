package com.example.moviedatabaseapp.presentation.di.tvshow

import com.example.moviedatabaseapp.domain.usecases.GetArtistsUseCase
import com.example.moviedatabaseapp.domain.usecases.GetTvShowsUseCase
import com.example.moviedatabaseapp.domain.usecases.UpdateArtistsUseCase
import com.example.moviedatabaseapp.domain.usecases.UpdateTvShowsUseCase
import com.example.moviedatabaseapp.presentation.artist.ArtistViewModel
import com.example.moviedatabaseapp.presentation.artist.ArtistViewModelFactory
import com.example.moviedatabaseapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ):TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}