package com.example.rickmorty.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickmorty.data.entities.Character
import com.example.rickmorty.data.entities.Episode
import com.example.rickmorty.data.entities.LocationInfo

@Database(
    entities = [
        Character::class,
        Episode::class,
        LocationInfo::class
    ], version = 1, exportSchema = false
)
abstract class RickMortyDatabase : RoomDatabase() {
    abstract fun dao(): RickMortyDao
}