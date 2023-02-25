package com.example.rickmorty

import androidx.fragment.app.Fragment

interface Navigator {
    fun showLocations()
    fun showEpisodes()
    fun showCharacters()
}

fun Fragment.navigate() = requireActivity() as Navigator