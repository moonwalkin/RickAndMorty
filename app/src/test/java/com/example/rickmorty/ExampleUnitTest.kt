package com.example.rickmorty

import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.Location
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.local.LocalDataSource
import com.example.rickmorty.data.remote.RemoteDataSource
import com.example.rickmorty.data.remote.RemoteDataSourceImpl
import com.example.rickmorty.data.repository.RickMortyRepositoryImpl
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.models.LocationUi
import kotlinx.coroutines.runBlocking
import com.example.rickmorty.domain.Result
import org.junit.Test

import org.junit.Assert.*
import kotlin.math.exp

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `repository should return data from db`() = runBlocking {
        val remoteDataSource = FakeRemoteDataSource()
        val localDataSource = FakeLocalDataSource()
        val repository = RickMortyRepositoryImpl(remoteDataSource, localDataSource)
        val result = repository.fetchCharacters()
        val actual1 = when (result) {
            is Result.Success -> {
                result.data
            }
            is Result.Error -> {

            }
            is Result.Loading -> {

            }
        }

        val actual2 = repository.fetchEpisodes()
        val actual3 = repository.fetchLocations()

        val expected1 = Result.Success(
            listOf(CharacterUi(
            "remoteGender",
            0,
            "remoteImage",
            LocationUi("remoteLocation"),
            "remoteName",
            "remoteSpecies",
            "remoteStatus"
        )))

        val expected2 = Result.Success(listOf(EpisodeUi(
            "remote01.01.01", "remoteEpisodeName0", 0, "remoteName0"
        )))

        val expected3 = Result.Success(listOf(
            LocationInfoUi(
                "remoteDimension0", 0, "remoteMame0", "remoteType0"
            ), LocationInfoUi("remoteDimension1", 1, "remoteName1", "remoteType1")
        ))
        assertEquals(actual1, expected1.data)
//        assertEquals(expected2, actual2)
//        assertEquals(expected3, actual3)
    }

    class FakeRemoteDataSource : RemoteDataSource {

        private val listLocations = listOf(
            LocationInfoUi(
                "remoteDimension0", 0, "remoteMame0", "remoteType0"
            ), LocationInfoUi("remoteDimension1", 1, "remoteName1", "remoteType1")
        )
        private val listEpisodes = listOf(
            EpisodeUi(
                "remote01.01.01", "remoteEpisodeName0", 0, "remoteName0"
            )
        )
        private val listCharacters = listOf(
            CharacterUi(
                "remoteGender",
                0,
                "remoteImage",
                LocationUi("remoteLocation"),
                "remoteName",
                "remoteSpecies",
                "remoteStatus"
            )
        )

        override suspend fun fetchLocations(): List<LocationInfoUi> {
            return listLocations
        }

        override suspend fun fetchEpisodes(): List<EpisodeUi> {
            return listEpisodes
        }

        override suspend fun fetchCharacters(): List<CharacterUi> {
            return listCharacters
        }
    }


    class FakeLocalDataSource : LocalDataSource {

        private val listCharacters = mutableListOf<CharacterUi>()
        private val listLocations = mutableListOf<LocationInfoUi>()
        private val listEpisodes = mutableListOf<EpisodeUi>()

        override suspend fun addCharacters(characters: List<Character>) {
            listCharacters.addAll(characters.map {
                CharacterUi(
                    it.gender,
                    it.id,
                    it.image,
                    LocationUi(it.location.locationName),
                    it.name,
                    it.species,
                    it.status
                )
            })
        }

        override suspend fun addLocations(locations: List<LocationInfo>) {

        }

        override suspend fun addEpisodes(episodes: List<Episode>) {
        }

        override suspend fun fetchEpisodes(): List<Episode> {
            return listEpisodes.map {
                Episode(
                    it.air_date,
                    it.episode, it.id, it.name
                )
            }
        }

        override suspend fun fetchCharacters(): List<Character> {
            return listCharacters.map {
                Character(
                    it.gender,
                    it.id,
                    it.image,
                    Location(it.location.name),
                    it.name,
                    it.species,
                    it.status
                )
            }
        }

        override suspend fun fetchLocations(): List<LocationInfo> {
            return listLocations.map {
                LocationInfo(
                    it.dimension,
                    it.id,
                    it.name,
                    it.type
                )
            }
        }
    }
}