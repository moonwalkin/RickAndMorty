package com.example.rickmorty.domain.repository

import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi

interface RickMortyRepository {

    suspend fun fetchLocations(): List<LocationInfoUi>

    suspend fun fetchEpisodes(): List<EpisodeUi>

    suspend fun fetchCharacters(): List<CharacterUi>

    suspend fun fetchSingleCharacter(id: Int): CharacterUi

    suspend fun fetchSingleLocation(id: Int): LocationInfoUi

    suspend fun fetchSingleEpisode(id: Int): EpisodeUi
}