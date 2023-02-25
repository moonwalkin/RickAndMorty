package com.example.rickmorty.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.rickmorty.data.Item

class CharacterDiffUtil : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}