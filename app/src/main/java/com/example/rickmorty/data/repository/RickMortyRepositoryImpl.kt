package com.example.rickmorty.data.repository

import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.Location
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.local.LocalDataSource
import com.example.rickmorty.data.remote.RemoteDataSource
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : RickMortyRepository {
    override suspend fun fetchLocations(): List<LocationInfoUi> {
        if (localDataSource.fetchLocations().isEmpty()) {
            localDataSource.addLocations(remoteDataSource.fetchLocations().map {
                LocationInfo(it.dimension, it.id, it.name, it.type)
            })
        }
        return localDataSource.fetchLocations().map { locations ->
            locations.map()
        }
    }

    override suspend fun fetchEpisodes(): List<EpisodeUi> {
        if (localDataSource.fetchEpisodes().isEmpty()) {
            localDataSource.addEpisodes(remoteDataSource.fetchEpisodes().map {
                Episode(it.air_date, it.episode, it.id, it.name)
            })
        }
        return localDataSource.fetchEpisodes().map { episodes ->
            episodes.map()
        }
    }

    override suspend fun fetchCharacters(): List<CharacterUi> {
        if (localDataSource.fetchCharacters().isEmpty()) {
            localDataSource.addCharacters(remoteDataSource.fetchCharacters().map {
                Character(
                    it.gender,
                    it.id,
                    it.image,
                    Location(it.location.name),
                    it.name,
                    it.species,
                    it.status
                )
            })
        }
        return localDataSource.fetchCharacters().map { characters ->
            characters.map()
        }
    }

    override suspend fun fetchSingleCharacter(id: Int): CharacterUi {
        return remoteDataSource.fetchSingleCharacter(id)
    }

    override suspend fun fetchSingleLocation(id: Int): LocationInfoUi {
        return remoteDataSource.fetchSingleLocation(id)
    }

    override suspend fun fetchSingleEpisode(id: Int): EpisodeUi {
        return remoteDataSource.fetchSingleEpisode(id)
    }
}