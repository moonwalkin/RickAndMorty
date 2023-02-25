package com.example.rickmorty.data

data class ResponseCharacters(
    val info: Info,
    val results: List<Character>
)