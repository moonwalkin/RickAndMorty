package com.example.rickmorty.data.entities

import com.squareup.moshi.Json

data class ResponseCharacters(
    @field:Json(name = "results")
    val characters: List<Character>,
    @field:Json(name = "info")
    val page: Page
)