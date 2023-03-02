package com.example.rickmorty.data.local

import com.example.rickmorty.data.database.RickMortyDao
import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: RickMortyDao) : LocalDataSource {
    override suspend fun addCharacters(characters: List<Character>) {
        dao.addCharacters(characters)
    }

    override suspend fun addLocations(locations: List<LocationInfo>) {
        dao.addLocations(locations)
    }

    override suspend fun addEpisodes(episodes: List<Episode>) {
        dao.addEpisodes(episodes)
    }

    override suspend fun fetchEpisodes(): List<Episode> {
        return dao.fetchEpisodes()
    }

    override suspend fun fetchCharacters(): List<Character> {
        return dao.fetchCharacters()
    }

    override suspend fun fetchLocations(): List<LocationInfo> {
        return dao.fetchLocations()
    }

}