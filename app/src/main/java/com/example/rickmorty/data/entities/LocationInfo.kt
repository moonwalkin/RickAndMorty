package com.example.rickmorty.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickmorty.data.mapper.Mapper
import com.example.rickmorty.domain.models.LocationInfoUi
import com.squareup.moshi.Json

@Entity(tableName = "location")
class LocationInfo(
    @field:Json(name = "dimension")
    val dimension: String,
    @Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "type")
    val type: String
) : Mapper<LocationInfoUi> {
    override fun map(): LocationInfoUi {
        return LocationInfoUi(
            dimension = dimension,
            name = name,
            type = type,
            id = id
        )
    }
}


