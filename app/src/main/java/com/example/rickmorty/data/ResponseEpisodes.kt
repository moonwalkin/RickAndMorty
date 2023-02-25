package com.example.rickmorty.data

data class ResponseEpisodes(
    val info: Info,
    val results: List<Episode>
)