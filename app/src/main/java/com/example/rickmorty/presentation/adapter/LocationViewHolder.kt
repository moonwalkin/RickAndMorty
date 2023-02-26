package com.example.rickmorty.presentation.adapter

import com.example.rickmorty.databinding.ItemLocationBinding
import com.example.rickmorty.domain.models.ItemUi
import com.example.rickmorty.domain.models.LocationUi

class LocationViewHolder(binding: ItemLocationBinding) :
    AbstractViewHolder<ItemLocationBinding>(binding) {
    override fun bind(item: ItemUi, listener: (Int) -> Unit) {
        val location = item as LocationUi
        binding.apply {
            tvName.text = location.name
            itemView.setOnClickListener {
                listener(location.id)
            }
        }
    }
}