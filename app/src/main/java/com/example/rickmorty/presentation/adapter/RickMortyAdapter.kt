package com.example.rickmorty.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.rickmorty.databinding.ItemCharacterBinding
import com.example.rickmorty.databinding.ItemEpisodeBinding
import com.example.rickmorty.databinding.ItemLocationBinding
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.ItemUi
import com.example.rickmorty.domain.models.LocationUi

class RickMortyAdapter(private val listener: (Int) -> Unit) : ListAdapter<ItemUi, AbstractViewHolder<ViewBinding>>(CharacterDiffUtil()) {
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
            is CharacterUi -> {
                CHARACTER_ITEM
            }
            is LocationUi -> {
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