package com.example.rickmorty.data.remote

import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.entities.Character

interface RemoteDataSource {

    suspend fun fetchLocations(): List<LocationInfo>

    suspend fun fetchEpisodes(): List<Episode>

    suspend fun fetchCharacters(): List<Character>

}