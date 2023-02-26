package com.example.rickmorty.data.repository

import com.example.rickmorty.data.RickMortyService
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(private val service: RickMortyService) :
    RickMortyRepository {
    override suspend fun fetchLocations(): List<LocationUi> {
        return try {
            service.fetchLocations().locations.map { locations ->
                locations.map()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchEpisodes(): List<EpisodeUi> {
        return try {
            service.fetchEpisodes().episodes.map { episodes ->
                episodes.map()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchCharacters(): List<CharacterUi> {
        return try {
            service.fetchCharacters().characters.map {
                it.map()
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchSingleCharacter(id: Int): CharacterUi {
        return try {
            service.fetchSingleCharacter(id).map()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchSingleLocation(id: Int): LocationUi {
        return try {
            service.fetchSingleLocation(id).map()
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchSingleEpisode(id: Int): EpisodeUi {
        return try {
            service.fetchSingleEpisode(id).map()
        } catch (e: Exception) {
            throw e
        }
    }
}