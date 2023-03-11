package com.example.rickmorty.data.network

import com.example.rickmorty.data.entities.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyService {
    @GET("location")
    suspend fun fetchLocations(@Query("page") page: Int): ResponseLocations

    @GET("character")
    suspend fun fetchCharacters(@Query("page") page: Int): ResponseCharacters

    @GET("episode")
    suspend fun fetchEpisodes(@Query("page") page: Int): ResponseEpisodes
}