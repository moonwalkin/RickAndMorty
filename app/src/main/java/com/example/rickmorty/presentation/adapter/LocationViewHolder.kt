package com.example.rickmorty.presentation.adapter

import com.example.rickmorty.data.Item
import com.example.rickmorty.data.LocationInfo
import com.example.rickmorty.databinding.ItemLocationBinding

class LocationViewHolder(binding: ItemLocationBinding) :
    AbstractViewHolder<ItemLocationBinding>(binding) {
    override fun bind(item: Item) {
        val location = item as LocationInfo
        binding.apply {
            tvName.text = location.name
        }
    }
}