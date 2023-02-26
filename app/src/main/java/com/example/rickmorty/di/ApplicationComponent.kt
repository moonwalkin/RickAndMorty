package com.example.rickmorty.di

import com.example.rickmorty.presentation.fragments.*
import dagger.Component


@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: CharactersFragment)
    fun inject(fragment: LocationsFragment)
    fun inject(fragment: DetailsCharacterFragment)
    fun inject(fragment: EpisodesFragment)
    fun inject(fragment: DetailsLocationFragment)
}