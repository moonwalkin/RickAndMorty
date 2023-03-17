package com.example.rickmorty.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickmorty.data.mapper.Mapper
import com.example.rickmorty.domain.models.EpisodeUi
import com.squareup.moshi.Json
@Entity(tableName = "episode")
data class Episode(
    @field:Json(name = "air_date")
    val air_date: String,
    @field:Json(name = "episode")
    val episode: String,
    @field:Json(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @field:Json(name = "name")
    val name: String,
) : Mapper<EpisodeUi> {
    override fun map(): EpisodeUi {
        return EpisodeUi(
            air_date = air_date,
            episode = episode,
            id = id,
            name = name
        )
    }
}