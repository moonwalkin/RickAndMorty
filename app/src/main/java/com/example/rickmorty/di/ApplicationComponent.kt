package com.example.rickmorty.di

import com.example.rickmorty.presentation.fragments.CharactersFragment
import dagger.Component


@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: CharactersFragment)
}