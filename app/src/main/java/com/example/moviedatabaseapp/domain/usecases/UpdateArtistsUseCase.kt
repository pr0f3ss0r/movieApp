package com.example.moviedatabaseapp.domain.usecases

import com.example.moviedatabaseapp.data.model.artist.Artist
import com.example.moviedatabaseapp.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}