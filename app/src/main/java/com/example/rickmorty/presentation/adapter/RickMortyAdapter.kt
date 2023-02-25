package com.example.rickmorty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.rickmorty.data.Character
import com.example.rickmorty.data.Item
import com.example.rickmorty.data.LocationInfo
import com.example.rickmorty.databinding.ItemCharacterBinding

class RickMortyAdapter : ListAdapter<Item, CharacterViewHolder>(CharacterDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is Character -> {
                holder.bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is Character -> {
                CHARACTER_ITEM
            }
            is LocationInfo -> {
                LOCATION_ITEM
            }
            else -> {
                EPISODE_ITEM
            }
        }
    }
    companion object {
        private const val CHARACTER_ITEM = 1
        private const val LOCATION_ITEM = 2
        private const val EPISODE_ITEM = 3
    }
}




