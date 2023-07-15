package com.example.rickmorty.di

import android.app.Application
import androidx.room.Room
import com.example.rickmorty.data.ResultHandler
import com.example.rickmorty.data.database.RickMortyDatabase
import com.example.rickmorty.data.local.LocalDataSource
import com.example.rickmorty.data.local.LocalDataSourceImpl
import com.example.rickmorty.data.remote.RemoteDataSource
import com.example.rickmorty.data.remote.RemoteDataSourceImpl
import com.example.rickmorty.data.network.RickMortyService
import com.example.rickmorty.data.repository.RickMortyRepositoryImpl
import com.example.rickmorty.domain.repository.RickMortyRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RickMortyRepositoryImpl): RickMortyRepository

    @Binds
    @ApplicationScope
    fun bindRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @ApplicationScope
    fun bindLocalDataSource(impl: LocalDataSourceImpl): LocalDataSource

    @Binds
    fun bindResultHandler(impl: ResultHandler.Base): ResultHandler

    companion object {

        @Provides
        @ApplicationScope
        fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .client(client)
            .build()

        @Provides
        @ApplicationScope
        fun provideService(retrofit: Retrofit): RickMortyService = retrofit.create()

        @Provides
        @ApplicationScope
        fun provideOkHttp() = OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        ).build()


        @Provides
        @ApplicationScope
        fun provideDao(application: Application) = Room.databaseBuilder(
            application,
            RickMortyDatabase::class.java,
            "rick_morty"
        )
            .build()
            .dao()
    }

}