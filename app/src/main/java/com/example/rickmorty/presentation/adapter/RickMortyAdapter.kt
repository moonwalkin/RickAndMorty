package com.example.rickmorty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.rickmorty.data.Character
import com.example.rickmorty.data.Item
import com.example.rickmorty.data.LocationInfo
import com.example.rickmorty.databinding.ItemCharacterBinding
import com.example.rickmorty.databinding.ItemEpisodeBinding
import com.example.rickmorty.databinding.ItemLocationBinding

class RickMortyAdapter(private val listener: (Int) -> Unit) : ListAdapter<Item, AbstractViewHolder<ViewBinding>>(CharacterDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<ViewBinding> {
        val viewHolder = when (viewType) {
            CHARACTER_ITEM -> CharacterViewHolder(ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
            LOCATION_ITEM -> LocationViewHolder(
                ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
            else -> EpisodeViewHolder(
                ItemEpisodeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AbstractViewHolder<ViewBinding>, position: Int) {
        holder.bind(getItem(position), listener)
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