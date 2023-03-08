package com.example.moviedatabaseapp.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviedatabaseapp.data.model.artist.Artist
import com.example.moviedatabaseapp.domain.usecases.GetArtistsUseCase
import com.example.moviedatabaseapp.domain.usecases.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {
    fun getArtist(): LiveData<List<Artist>?> = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }
    fun updateArtist(): LiveData<List<Artist>?> = liveData {
        val artistList: List<Artist>? = updateArtistsUseCase.execute()
        emit(artistList)
    }
}