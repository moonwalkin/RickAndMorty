package com.example.rickmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.rickmorty.Navigator
import com.example.rickmorty.R

class MainActivity : AppCompatActivity(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null).commit()
    }

    override fun showLocations() {
        launchFragment(LocationsFragment())
    }

    override fun showEpisodes() {
        launchFragment(EpisodesFragment())
    }

    override fun showCharacters() {
        launchFragment(CharactersFragment())
    }
}