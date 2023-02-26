package com.example.rickmorty.domain.models

import com.example.rickmorty.data.entities.Location

class CharacterUi(
    val gender: String,
    id: Int,
    val image: String,
    val location: Location,
    name: String,
    val species: String,
    val status: String,
) : ItemUi(id, name)