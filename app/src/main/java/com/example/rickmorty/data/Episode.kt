package com.example.rickmorty.data

class Episode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    id: Int,
    val name: String,
    val url: String
) : Item(id)