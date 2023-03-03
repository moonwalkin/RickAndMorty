package com.example.rickmorty.data.repository

import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.Location
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.local.LocalDataSource
import com.example.rickmorty.data.remote.RemoteDataSource
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.Result
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : RickMortyRepository {
    override suspend fun fetchLocations(): Result<List<LocationInfoUi>> {
        return try {
            if (localDataSource.fetchLocations().isEmpty()) {
                localDataSource.addLocations(remoteDataSource.fetchLocations().map {
                    LocationInfo(it.dimension, it.id, it.name, it.type)
                })
            }
            Result.Success(
                localDataSource.fetchLocations().map { locations ->
                    locations.map()
                })
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchEpisodes(): Result<List<EpisodeUi>> {
        return try {
            if (localDataSource.fetchEpisodes().isEmpty()) {
                localDataSource.addEpisodes(remoteDataSource.fetchEpisodes().map {
                    Episode(it.air_date, it.episode, it.id, it.name)
                })
            }
            Result.Success(localDataSource.fetchEpisodes().map { episodes ->
                episodes.map()
            })
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun fetchCharacters(): Result<List<CharacterUi>> {
        return try {
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
            Result.Success(localDataSource.fetchCharacters().map { characters ->
                characters.map()
            })
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}