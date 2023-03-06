package com.example.rickmorty.presentation

import androidx.fragment.app.Fragment
import com.example.rickmorty.domain.models.ItemUi

interface Navigator {
    fun showLocations()
    fun showEpisodes()
    fun showCharacters()
    fun showDetails(item: ItemUi)
}

fun Fragment.navigate() = requireActivity() as Navigator