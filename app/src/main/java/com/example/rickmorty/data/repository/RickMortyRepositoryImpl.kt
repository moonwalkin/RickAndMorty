package com.example.rickmorty.data.repository

import com.example.rickmorty.data.remote.RemoteDataSource
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(private val cloudDataSource: RemoteDataSource) :
    RickMortyRepository {
    override suspend fun fetchLocations(): List<LocationInfoUi> {
        return cloudDataSource.fetchLocations()
    }

    override suspend fun fetchEpisodes(): List<EpisodeUi> {
        return cloudDataSource.fetchEpisodes()
    }

    override suspend fun fetchCharacters(): List<CharacterUi> {
        return cloudDataSource.fetchCharacters()
    }

    override suspend fun fetchSingleCharacter(id: Int): CharacterUi {
        return cloudDataSource.fetchSingleCharacter(id)
    }

    override suspend fun fetchSingleLocation(id: Int): LocationInfoUi {
        return cloudDataSource.fetchSingleLocation(id)
    }

    override suspend fun fetchSingleEpisode(id: Int): EpisodeUi {
        return cloudDataSource.fetchSingleEpisode(id)
    }
}