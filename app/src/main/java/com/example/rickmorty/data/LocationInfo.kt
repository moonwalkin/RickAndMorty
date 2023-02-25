package com.example.rickmorty.data

class LocationInfo(
    val created: String,
    val dimension: String,
    id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) : Item(id)