package com.example.rickmorty.data.remote

import com.example.rickmorty.data.network.RickMortyService
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: RickMortyService) :
    RemoteDataSource {
    override suspend fun fetchLocations(): List<LocationInfoUi> {
        return try {
            service.fetchLocations().locations.map { locations ->
                locations.map()
            }
        } catch (e: Exception) {
            throw RuntimeException("No Internet connection")
        }
    }

    override suspend fun fetchEpisodes(): List<EpisodeUi> {
        return try {
            service.fetchEpisodes().episodes.map { episodes ->
                episodes.map()
            }
        } catch (e: Exception) {
            throw RuntimeException("No Internet connection")
        }
    }

    override suspend fun fetchCharacters(): List<CharacterUi> {
        return try {
            service.fetchCharacters().characters.map {
                it.map()
            }
        } catch (e: Exception) {
            throw RuntimeException("No Internet connection")
        }
    }
}