package com.example.rickmorty.data.local

import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo

interface LocalDataSource {

    suspend fun addCharacters(characters: List<Character>)

    suspend fun addLocations(locations: List<LocationInfo>)

    suspend fun addEpisodes(episodes: List<Episode>)

    suspend fun fetchEpisodes(): List<Episode>

    suspend fun fetchCharacters(): List<Character>

    suspend fun fetchLocations(): List<LocationInfo>
}