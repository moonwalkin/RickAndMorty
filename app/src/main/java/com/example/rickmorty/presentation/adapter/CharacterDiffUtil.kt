package com.example.rickmorty.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.rickmorty.domain.models.ItemUi

class CharacterDiffUtil : DiffUtil.ItemCallback<ItemUi>() {
    override fun areItemsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ItemUi, newItem: ItemUi): Boolean {
        return oldItem == newItem
    }
}