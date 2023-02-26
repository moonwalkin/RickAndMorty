package com.example.rickmorty.data

import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyService {
    @GET("location")
    suspend fun fetchLocations(): ResponseLocations

    @GET("character")
    suspend fun fetchCharacters(): ResponseCharacters

    @GET("episode")
    suspend fun fetchEpisodes(): ResponseEpisodes

    @GET("character/{id}")
    suspend fun fetchSingleCharacter(@Path("id") id: Int): Character


}