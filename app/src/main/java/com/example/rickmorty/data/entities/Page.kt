package com.example.rickmorty.data.entities

import com.squareup.moshi.Json

class Page(
    @field:Json(name = "pages")
    val pagesCount: Int,
)