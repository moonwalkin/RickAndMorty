package com.example.rickmorty.data

import retrofit2.http.GET

interface RickMortyService {
    @GET("location")
    suspend fun fetchLocations(): ResponseLocations

    @GET("character")
    suspend fun fetchCharacters(): ResponseCharacters

    @GET("episode")
    suspend fun fetchEpisodes(): ResponseEpisodes


}