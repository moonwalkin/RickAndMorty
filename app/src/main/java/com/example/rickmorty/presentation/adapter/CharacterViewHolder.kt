package com.example.rickmorty.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickmorty.data.Character
import com.example.rickmorty.data.Episode
import com.example.rickmorty.data.LocationInfo
import com.example.rickmorty.databinding.ItemCharacterBinding
import com.example.rickmorty.databinding.ItemEpisodeBinding
import com.example.rickmorty.databinding.ItemLocationBinding

class CharacterViewHolder(private val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(character: Character) {
        binding.apply {
            tvName.text = character.name
            Glide.with(root).load(character.image)
                .circleCrop()
                .into(ivCharacter)
        }

    }
}

class LocationViewHolder(private val binding: ItemLocationBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(location: LocationInfo) {
        binding.apply {
            tvName.text = location.name
        }

    }
}

class EpisodeViewHolder(private val binding: ItemEpisodeBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(episode: Episode) {
        binding.apply {
        }

    }
}