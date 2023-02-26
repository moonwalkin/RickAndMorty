package com.example.rickmorty.data.entities

import com.squareup.moshi.Json

data class Location(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)