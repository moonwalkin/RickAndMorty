package com.example.rickmorty.data.entities

import com.squareup.moshi.Json

data class ResponseEpisodes(
    @field:Json(name = "results")
    val episodes: List<Episode>,
    @field:Json(name = "info")
    val page: Page
)