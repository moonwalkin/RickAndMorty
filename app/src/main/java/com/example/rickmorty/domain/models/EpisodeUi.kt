package com.example.rickmorty.domain.models

import java.io.Serializable


class EpisodeUi(
    val air_date: String,
    val episode: String,
    id: Int,
    name: String,
): ItemUi(id, name), Serializable