package com.example.rickmorty.data.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickmorty.data.mapper.Mapper
import com.example.rickmorty.domain.models.CharacterUi
import com.squareup.moshi.Json

@Entity(tableName = "character")
class Character(
    @field:Json(name = "gender")
    val gender: String,
    @field:Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "location")
    @Embedded
    val location: Location,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "species")
    val species: String,
    @field:Json(name = "status")
    val status: String,
) : Mapper<CharacterUi> {
    override fun map(): CharacterUi {
        return CharacterUi(
            gender = gender,
            image = image,
            location = location.map(),
            name = name,
            species = species,
            status = status,
            id = id
        )
    }
}