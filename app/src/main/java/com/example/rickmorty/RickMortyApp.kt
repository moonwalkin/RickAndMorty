package com.example.rickmorty

import android.app.Application
import com.example.rickmorty.di.ApplicationComponent
import com.example.rickmorty.di.DaggerApplicationComponent

class RickMortyApp : Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }
}