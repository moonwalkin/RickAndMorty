package com.example.rickmorty.presentation.adapter

import com.bumptech.glide.Glide
import com.example.rickmorty.data.Character
import com.example.rickmorty.data.Item
import com.example.rickmorty.databinding.ItemCharacterBinding

class CharacterViewHolder(binding: ItemCharacterBinding) :
    AbstractViewHolder<ItemCharacterBinding>(binding) {
    override fun bind(item: Item, listener: (Int) -> Unit) {
        val character = item as Character
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