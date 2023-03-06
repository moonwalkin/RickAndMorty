package com.example.rickmorty.data.network

import com.example.rickmorty.data.entities.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyService {
    @GET("location")
    suspend fun fetchLocations(): ResponseLocations

    @GET("character")
    suspend fun fetchCharacters(): ResponseCharacters

    @GET("episode")
    suspend fun fetchEpisodes(): ResponseEpisodes
}