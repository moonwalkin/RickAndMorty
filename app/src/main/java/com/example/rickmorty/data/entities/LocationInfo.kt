package com.example.rickmorty.data.entities

import com.example.rickmorty.data.mapper.Mapper
import com.example.rickmorty.domain.models.LocationUi
import com.squareup.moshi.Json

class LocationInfo(
    @field:Json(name = "dimension")
    val dimension: String,
    @Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "type")
    val type: String
) : Mapper<LocationUi> {
    override fun map(): LocationUi {
        return LocationUi(
            dimension = dimension,
            name = name,
            type = type,
            id = id
        )
    }
}


