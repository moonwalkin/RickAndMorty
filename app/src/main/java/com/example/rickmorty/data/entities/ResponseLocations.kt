package com.example.rickmorty.data.entities

import com.squareup.moshi.Json

data class ResponseLocations(
    @field:Json(name = "results")
    val locations: List<LocationInfo>,
    @field:Json(name = "info")
    val page: Page
)