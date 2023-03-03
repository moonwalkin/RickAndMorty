package com.example.rickmorty.presentation.adapter

import com.example.rickmorty.databinding.ItemLocationBinding
import com.example.rickmorty.domain.models.ItemUi
import com.example.rickmorty.domain.models.LocationInfoUi

class LocationViewHolder(binding: ItemLocationBinding) :
    AbstractViewHolder<ItemLocationBinding>(binding) {
    override fun bind(item: ItemUi, listener: (ItemUi) -> Unit) {
        val location = item as LocationInfoUi
        binding.apply {
            tvName.text = location.name
            itemView.setOnClickListener {
                listener(location)
            }
        }
    }
}