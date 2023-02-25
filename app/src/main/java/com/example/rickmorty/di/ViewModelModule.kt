package com.example.rickmorty.di

import androidx.lifecycle.ViewModel
import com.example.rickmorty.presentation.viewmodels.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelScope(CharacterViewModel::class)
    fun bindCharacterViewModel(viewModel: CharacterViewModel): ViewModel
}