package com.example.rickmorty.domain

import com.example.rickmorty.data.*

interface RickMortyRepository {

    suspend fun fetchLocations(): ResponseLocations

    suspend fun fetchEpisodes(): ResponseEpisodes

    suspend fun fetchCharacters(): ResponseCharacters

    suspend fun fetchSingleCharacter(id: Int): Character

    suspend fun fetchSingleLocation(id: Int): LocationInfo

    suspend fun fetchSingleEpisode(id: Int): Episode
}