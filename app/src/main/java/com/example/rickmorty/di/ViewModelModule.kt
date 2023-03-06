package com.example.rickmorty.di

import androidx.lifecycle.ViewModel
import com.example.rickmorty.presentation.viewmodels.CharacterViewModel
import com.example.rickmorty.presentation.viewmodels.EpisodeViewModel
import com.example.rickmorty.presentation.viewmodels.LocationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelScope(CharacterViewModel::class)
    fun bindCharacterViewModel(viewModel: CharacterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(LocationViewModel::class)
    fun bindLocationViewModel(viewModel: LocationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelScope(EpisodeViewModel::class)
    fun bindEpisodeViewModel(viewModel: EpisodeViewModel): ViewModel
}