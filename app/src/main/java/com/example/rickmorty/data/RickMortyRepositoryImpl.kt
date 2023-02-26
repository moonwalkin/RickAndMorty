package com.example.rickmorty.data

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.flow.Flow
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

    override suspend fun fetchSingleLocation(id: Int): LocationInfo {
        return try {
            service.fetchSingleLocation(id)
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun fetchSingleEpisode(id: Int): Episode {
        return try {
            service.fetchSingleEpisode(id)
        } catch (e: Exception) {
            throw e
        }
    }
}