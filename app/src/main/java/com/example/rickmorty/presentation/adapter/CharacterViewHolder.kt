package com.example.rickmorty.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickmorty.data.Character
import com.example.rickmorty.databinding.ItemCharacterBinding

class CharacterViewHolder(private val binding: ItemCharacterBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(character: Character) {
        binding.apply {
            tvName.text = character.name
            Glide.with(root).load(character.image).into(ivCharacter)
        }

    }
}