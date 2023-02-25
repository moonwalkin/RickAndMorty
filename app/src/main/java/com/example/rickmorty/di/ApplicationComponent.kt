package com.example.rickmorty.di

import com.example.rickmorty.presentation.fragments.CharactersFragment
import com.example.rickmorty.presentation.fragments.EpisodesFragment
import com.example.rickmorty.presentation.fragments.LocationsFragment
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

    fun inject(fragment: EpisodesFragment)
}