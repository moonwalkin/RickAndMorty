package com.example.rickmorty

import android.app.Application
import com.example.rickmorty.di.DaggerApplicationComponent

class RickMortyApp : Application() {
    val component by lazy {
        DaggerApplicationComponent.create()
    }
}