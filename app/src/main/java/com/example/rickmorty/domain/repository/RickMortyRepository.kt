package com.example.rickmorty.domain.repository

import com.example.rickmorty.domain.Result
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi

interface RickMortyRepository {

    suspend fun fetchLocations(): Result<List<LocationInfoUi>>

    suspend fun fetchEpisodes(): Result<List<EpisodeUi>>

    suspend fun fetchCharacters(): Result<List<CharacterUi>>
}