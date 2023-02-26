package com.example.rickmorty.presentation.adapter

import com.bumptech.glide.Glide
import com.example.rickmorty.databinding.ItemCharacterBinding
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.ItemUi

class CharacterViewHolder(binding: ItemCharacterBinding) :
    AbstractViewHolder<ItemCharacterBinding>(binding) {
    override fun bind(item: ItemUi, listener: (Int) -> Unit) {
        val character = item as CharacterUi
        binding.apply {
            tvName.text = character.name
            itemView.setOnClickListener {
                listener(item.id)
            }
            Glide.with(root).load(character.image)
                .circleCrop()
                .into(ivCharacter)
        }

    }
}