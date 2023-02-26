package com.example.rickmorty.data

import com.squareup.moshi.Json


class Character(
    val gender: String,
    @Json(name = "id") id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val species: String,
    val status: String,
) : Item(id)