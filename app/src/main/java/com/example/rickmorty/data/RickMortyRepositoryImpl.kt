package com.example.rickmorty.data

import com.example.rickmorty.domain.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(private val service: RickMortyService) :
    RickMortyRepository {
    override suspend fun fetchLocations(): ResponseLocations {
        return try {
            service.fetchLocations()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchEpisodes(): ResponseEpisodes {
        return try {
            service.fetchEpisodes()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchCharacters(): ResponseCharacters {
        return try {
            service.fetchCharacters()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchSingleCharacter(id: Int): Character {
        return try {
            service.fetchSingleCharacter(id)
        } catch (e: Exception) {
            throw e
        }
    }
}