package com.example.rickmorty

import com.example.rickmorty.data.entities.*
import com.example.rickmorty.data.network.RickMortyService
import com.example.rickmorty.data.remote.RemoteDataSource
import com.example.rickmorty.data.remote.RemoteDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class RemoteDataSourceTest {

    private lateinit var rickMortyService: RickMortyService
    private lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun init() {
        rickMortyService = RickMortyServiceTest()
        remoteDataSource = RemoteDataSourceImpl(rickMortyService)
    }

    @Test
    fun `should return character list`() = runBlocking {
        val expected = listOf(
            Character(
                "remoteGender0",
                0,
                "remoteImage0",
                Location("remoteLocation0"),
                "remoteName0",
                "remoteSpecies0",
                "remoteStatus0"
            ),
            Character(
                "remoteGender0",
                1,
                "remoteImage0",
                Location("remoteLocation0"),
                "remoteName0",
                "remoteSpecies0",
                "remoteStatus0"
            )
        )
        val actual = remoteDataSource.fetchCharacters()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return location list`() = runBlocking {
        val expected = listOf(
            LocationInfo(
                "remoteDimension0", 0, "remoteMame0", "remoteType0"
            ), LocationInfo("remoteDimension1", 1, "remoteName1", "remoteType1")
        )
        val actual = remoteDataSource.fetchLocations()

        assertEquals(expected, actual)
    }

    @Test
    fun `should return episode list`() = runBlocking {
        val expected = listOf(
                Episode(
                    "remote00.00.00", "remoteEpisodeName0", 0, "remoteName0"
                ),
                Episode("remote01.01.01", "remoteEpisodeName1", 1, "remoteName1")
            )
        val actual = remoteDataSource.fetchEpisodes()

        assertEquals(expected, actual)
    }

    private class RickMortyServiceTest : RickMortyService {

        private val listOfCharacters = ResponseCharacters(
            listOf(
                Character(
                    "remoteGender0",
                    0,
                    "remoteImage0",
                    Location("remoteLocation0"),
                    "remoteName0",
                    "remoteSpecies0",
                    "remoteStatus0"
                ),
                Character(
                    "remoteGender0",
                    1,
                    "remoteImage0",
                    Location("remoteLocation0"),
                    "remoteName0",
                    "remoteSpecies0",
                    "remoteStatus0"
                )
            ),
            Page(5)
        )

        private val listOfEpisodes = ResponseEpisodes(
            listOf(
                Episode(
                    "remote00.00.00", "remoteEpisodeName0", 0, "remoteName0"
                ),
                Episode("remote01.01.01", "remoteEpisodeName1", 1, "remoteName1")
            ),
            Page(5)
        )

        private val listOfLocations = ResponseLocations(
            listOf(
                LocationInfo(
                    "remoteDimension0", 0, "remoteMame0", "remoteType0"
                ), LocationInfo("remoteDimension1", 1, "remoteName1", "remoteType1")
            ),
            Page(5)
        )


        override suspend fun fetchLocations(page: Int): ResponseLocations {
            return listOfLocations
        }

        override suspend fun fetchCharacters(page: Int): ResponseCharacters {
            return listOfCharacters
        }

        override suspend fun fetchEpisodes(page: Int): ResponseEpisodes {
            return listOfEpisodes
        }
    }
}