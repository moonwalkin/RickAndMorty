package com.example.rickmorty.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo

@Dao
interface RickMortyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(characters: List<Character>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLocations(locations: List<LocationInfo>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEpisodes(episodes: List<Episode>)

    @Query("SELECT * FROM episode")
    suspend fun fetchEpisodes(): List<Episode>

    @Query("SELECT * FROM character")
    suspend fun fetchCharacters(): List<Character>

    @Query("SELECT * FROM location")
    suspend fun fetchLocations(): List<LocationInfo>
}