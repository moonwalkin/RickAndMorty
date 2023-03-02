package com.example.rickmorty.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickmorty.data.entities.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class RickMortyDatabase : RoomDatabase() {
    abstract fun dao(): RickMortyDao
}