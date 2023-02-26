package com.example.rickmorty

import androidx.fragment.app.Fragment

interface Navigator {
    fun showLocations()
    fun showEpisodes()
    fun showCharacters()
    fun showDetails(id: Int)
}

fun Fragment.navigate() = requireActivity() as Navigator