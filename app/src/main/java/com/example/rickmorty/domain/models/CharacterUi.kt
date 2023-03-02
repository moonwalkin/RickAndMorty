package com.example.rickmorty.domain.models


class CharacterUi(
    val gender: String,
    id: Int,
    val image: String,
    val location: LocationUi,
    name: String,
    val species: String,
    val status: String,
) : ItemUi(id, name)