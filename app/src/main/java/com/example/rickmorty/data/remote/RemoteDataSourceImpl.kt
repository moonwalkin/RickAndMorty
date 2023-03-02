package com.example.rickmorty.data.remote

import com.example.rickmorty.data.network.RickMortyService
import com.example.rickmorty.domain.NoConnectionException
import com.example.rickmorty.domain.ServiceUnavailableException
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: RickMortyService) : RemoteDataSource  {
    override suspend fun fetchLocations(): List<LocationInfoUi> {
        return try {
            service.fetchLocations().locations.map { locations ->
                locations.map()
            }
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
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

    override suspend fun fetchSingleLocation(id: Int): LocationInfoUi {
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