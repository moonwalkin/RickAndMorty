package com.example.rickmorty

import com.example.rickmorty.data.database.RickMortyDao
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.Location
import com.example.rickmorty.data.entities.LocationInfo
import com.example.rickmorty.data.local.LocalDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import com.example.rickmorty.data.entities.Character
import org.junit.Assert.assertEquals

class LocalDataSourceTest {

    @Test
    fun `add items to character list should increase list size`() = runBlocking {
        val rickMortyDao = RickMortyDaoTest()
        val localDataSource = LocalDataSourceImpl(rickMortyDao)

        val expected = 2
        localDataSource.addCharacters(
            listOf(
                Character(
                    "localGender0",
                    0,
                    "localImage0",
                    Location("localLocation0"),
                    "localName0",
                    "localSpecies0",
                    "localStatus0"
                ),
                Character(
                    "localGender0",
                    1,
                    "localImage0",
                    Location("localLocation0"),
                    "localName0",
                    "localSpecies0",
                    "localStatus0"
                )
            )
        )
        val actual = rickMortyDao.listOfCharacters.size
        assertEquals(expected, actual)
    }

    @Test
    fun `add items to location list should increase list size`() = runBlocking {
        val rickMortyDao = RickMortyDaoTest()
        val localDataSource = LocalDataSourceImpl(rickMortyDao)

        val expected = 2
        localDataSource.addLocations(
            listOf(
                LocationInfo(
                    "localDimension0", 0, "localMame0", "localType0"
                ), LocationInfo("localDimension1", 1, "localName1", "localType1")
            )
        )
        val actual = rickMortyDao.listOfLocations.size
        assertEquals(expected, actual)
    }

    @Test
    fun `add items to episode list should increase list size`() = runBlocking {
        val rickMortyDao = RickMortyDaoTest()
        val localDataSource = LocalDataSourceImpl(rickMortyDao)

        val expected = 2
        localDataSource.addEpisodes(
            listOf(
                Episode(
                    "local00.00.00", "localEpisodeName0", 0, "localName0"
                ),
                Episode("local01.01.01", "localEpisodeName1", 1, "localName1")
            )
        )
        val actual = rickMortyDao.listOfEpisodes.size
        assertEquals(expected, actual)
    }


    private class RickMortyDaoTest : RickMortyDao {

        val listOfCharacters = mutableListOf<Character>()
        val listOfLocations = mutableListOf<LocationInfo>()
        val listOfEpisodes = mutableListOf<Episode>()

        override suspend fun addCharacters(characters: List<Character>) {
            characters.map {
                listOfCharacters.add(it)
            }
        }

        override suspend fun addLocations(locations: List<LocationInfo>) {
            locations.map {
                listOfLocations.add(it)
            }
        }

        override suspend fun addEpisodes(episodes: List<Episode>) {
            episodes.map {
                listOfEpisodes.add(it)
            }
        }

        override suspend fun fetchEpisodes(): List<Episode> {
            return listOf()
        }

        override suspend fun fetchCharacters(): List<Character> {
            return listOf()
        }

        override suspend fun fetchLocations(): List<LocationInfo> {
            return listOf()
        }
    }
}