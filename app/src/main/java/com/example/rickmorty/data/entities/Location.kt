package com.example.rickmorty.data.entities

import com.example.rickmorty.data.mapper.Mapper
import com.example.rickmorty.domain.models.LocationUi
import com.squareup.moshi.Json

data class Location(
    @field:Json(name = "name")
    val locationName: String,
) : Mapper<LocationUi> {
    override fun map(): LocationUi {
        return LocationUi(name = locationName)
    }
}