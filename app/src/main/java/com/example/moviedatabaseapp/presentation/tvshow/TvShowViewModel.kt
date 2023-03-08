package com.example.moviedatabaseapp.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviedatabaseapp.data.model.tvshow.TvShow
import com.example.moviedatabaseapp.domain.usecases.GetTvShowsUseCase
import com.example.moviedatabaseapp.domain.usecases.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {
    fun getTvShow(): LiveData<List<TvShow>?> = liveData {
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }
    fun updateTvShow(): LiveData<List<TvShow>?> = liveData {
        val tvShowList: List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}