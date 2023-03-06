package com.example.rickmorty.data.remote

import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.network.RickMortyService
import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.domain.NoConnectionException
import com.example.rickmorty.domain.ServiceUnavailableException
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: RickMortyService) :
    RemoteDataSource {
    override suspend fun fetchLocations(): List<LocationInfo> {
        return try {
            service.fetchLocations().locations
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }

    override suspend fun fetchEpisodes(): List<Episode> {
        return try {
            service.fetchEpisodes().episodes
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }

    override suspend fun fetchCharacters(): List<Character> {
        return try {
            service.fetchCharacters().characters
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }

}