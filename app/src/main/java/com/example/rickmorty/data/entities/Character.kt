package com.example.rickmorty.data.entities

import com.example.rickmorty.data.mapper.Mapper
import com.example.rickmorty.domain.models.CharacterUi
import com.squareup.moshi.Json


class Character(
    @field:Json(name = "gender")
    val gender: String,
    @Json(name = "id") id: Int,
    @field:Json(name = "image")
    val image: String,
    @field:Json(name = "location")
    val location: Location,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "species")
    val species: String,
    @field:Json(name = "status")
    val status: String,
) : Item(id), Mapper<CharacterUi> {
    override fun map(): CharacterUi {
        return CharacterUi(
            gender = gender,
            image = image,
            location = location,
            name = name,
            species = species,
            status = status,
            id = id
        )
    }
}