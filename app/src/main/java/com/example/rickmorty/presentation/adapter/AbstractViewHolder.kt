package com.example.rickmorty.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.rickmorty.domain.models.ItemUi


abstract class AbstractViewHolder<out VB : ViewBinding>(
    val binding: VB
    ) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: ItemUi, listener: (Int) -> Unit)
}