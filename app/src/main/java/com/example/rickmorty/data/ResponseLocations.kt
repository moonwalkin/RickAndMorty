package com.example.rickmorty.data

data class ResponseLocations(
    val info: Info,
    val results: List<LocationInfo>
)