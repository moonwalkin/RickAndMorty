package com.example.rickmorty.di

import com.example.rickmorty.data.repository.RickMortyRepositoryImpl
import com.example.rickmorty.data.RickMortyService
import com.example.rickmorty.domain.repository.RickMortyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RickMortyRepositoryImpl): RickMortyRepository

    companion object {
        @Provides
        fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

        @Provides
        fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(client)
            .build()

        @Provides
        fun provideService(retrofit: Retrofit): RickMortyService = retrofit.create()

        @Provides
        fun provideOkHttp() = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()
    }
}