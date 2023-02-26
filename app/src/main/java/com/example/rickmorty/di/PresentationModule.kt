package com.example.rickmorty.di

import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.LocationUi
import com.example.rickmorty.presentation.Communication
import com.example.rickmorty.presentation.CommunicationImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
interface PresentationModule {

    @Binds
    fun bindCommunicationCharacter(impl: CommunicationImpl<CharacterUi>): Communication<CharacterUi>
    @Binds
    fun bindCommunicationLocation(impl: CommunicationImpl<LocationUi>): Communication<LocationUi>
    @Binds
    fun bindCommunicationEpisode(impl: CommunicationImpl<EpisodeUi>): Communication<EpisodeUi>

    companion object {
        @Provides
        fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
    }
}