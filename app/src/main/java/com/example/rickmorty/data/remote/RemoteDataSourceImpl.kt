package com.example.rickmorty.data.remote

import com.example.rickmorty.domain.NoConnectionException
import com.example.rickmorty.domain.ServiceUnavailableException
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.network.RickMortyService
import com.example.rickmorty.data.entities.Character
import java.net.UnknownHostException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: RickMortyService
) :
    RemoteDataSource {
    private var pageOfCharacters = 1
    private var pageOfLocations = 1
    private var pageOfEpisodes = 1

    override suspend fun fetchLocations(): List<LocationInfo> {
        return try {
            val data = service.fetchLocations(pageOfLocations)
            if (pageOfLocations < data.page.pagesCount) pageOfLocations++
            data.locations
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
            val data = service.fetchEpisodes(pageOfEpisodes)
            if (pageOfEpisodes < data.page.pagesCount) pageOfEpisodes++
            data.episodes
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
            val data = service.fetchCharacters(pageOfCharacters)
            if (pageOfCharacters < data.page.pagesCount) pageOfCharacters++
            data.characters
        } catch (e: Exception) {
            if (e is UnknownHostException) {
                throw NoConnectionException()
            } else {
                throw ServiceUnavailableException()
            }
        }
    }

}