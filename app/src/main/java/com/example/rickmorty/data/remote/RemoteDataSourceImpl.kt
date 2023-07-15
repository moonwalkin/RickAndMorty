package com.example.rickmorty.data.remote

import com.example.rickmorty.data.ResultHandler
import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.network.RickMortyService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: RickMortyService,
    private val resultHandler: ResultHandler
) :
    RemoteDataSource {
    private var pageOfCharacters = 1
    private var pageOfLocations = 1
    private var pageOfEpisodes = 1

    override suspend fun fetchLocations(): List<LocationInfo> {
        return resultHandler.handle {
            val data = service.fetchLocations(pageOfLocations)
            if (pageOfLocations < data.page.pagesCount) pageOfLocations++
            data.locations
        }
    }

    override suspend fun fetchEpisodes(): List<Episode> {
        return resultHandler.handle {
            val data = service.fetchEpisodes(pageOfEpisodes)
            if (pageOfEpisodes < data.page.pagesCount) pageOfEpisodes++
            data.episodes
        }
    }

    override suspend fun fetchCharacters(): List<Character> {
        return resultHandler.handle {
            val data = service.fetchCharacters(pageOfCharacters)
            if (pageOfCharacters < data.page.pagesCount) pageOfCharacters++
            data.characters
        }
    }
}