package com.example.moviedatabaseapp.domain.usecases

import com.example.moviedatabaseapp.data.model.tvshow.TvShow
import com.example.moviedatabaseapp.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}