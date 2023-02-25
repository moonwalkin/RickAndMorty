package com.example.rickmorty.domain

import com.example.rickmorty.data.ResponseCharacters
import com.example.rickmorty.data.ResponseEpisodes
import com.example.rickmorty.data.ResponseLocations

interface RickMortyRepository {

    suspend fun fetchLocations(): ResponseLocations

    suspend fun fetchEpisodes(): ResponseEpisodes

    suspend fun fetchCharacters(): ResponseCharacters
}