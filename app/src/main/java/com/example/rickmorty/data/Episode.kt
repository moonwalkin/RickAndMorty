package com.example.rickmorty.data

class Episode(
    val air_date: String,
    val episode: String,
    id: Int,
    val name: String,
) : Item(id)