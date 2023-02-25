package com.example.rickmorty.presentation.adapter

import com.example.rickmorty.R
import com.example.rickmorty.data.Episode
import com.example.rickmorty.data.Item
import com.example.rickmorty.databinding.ItemEpisodeBinding

class EpisodeViewHolder(binding: ItemEpisodeBinding) :
    AbstractViewHolder<ItemEpisodeBinding>(binding) {
    override fun bind(item: Item) {
        val episode = item as Episode
        binding.apply {
            tvEpisodeName.text =
                root.context.getString(R.string.episode_info, episode.episode, episode.name)
        }
    }
}