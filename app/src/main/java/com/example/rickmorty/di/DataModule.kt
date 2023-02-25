package com.example.rickmorty.di

import com.example.rickmorty.data.RickMortyRepositoryImpl
import com.example.rickmorty.data.RickMortyService
import com.example.rickmorty.domain.RickMortyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RickMortyRepositoryImpl): RickMortyRepository

    companion object {

        @Provides
        fun provideRetrofit() = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()

        @Provides
        fun provideService(retrofit: Retrofit): RickMortyService = retrofit.create()
    }
}