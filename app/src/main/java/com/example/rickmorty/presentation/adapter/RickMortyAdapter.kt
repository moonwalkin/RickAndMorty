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
import com.example.rickmorty.domain.models.LocationInfoUi

class RickMortyAdapter(private val listener: (ItemUi) -> Unit) : ListAdapter<ItemUi, AbstractViewHolder<ViewBinding>>(CharacterDiffUtil()) {
    var onScroll: (() -> Unit) = {}
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
        val item = getItem(position)
        holder.bind(item, listener)
        if (currentList.size - 3 > 3 && position > currentList.size - 3) {
            onScroll()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is CharacterUi -> {
                CHARACTER_ITEM
            }
            is LocationInfoUi -> {
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