package com.example.rickmorty.presentation.adapter

import com.example.rickmorty.R
import com.example.rickmorty.databinding.ItemEpisodeBinding
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.models.ItemUi

class EpisodeViewHolder(binding: ItemEpisodeBinding) :
    AbstractViewHolder<ItemEpisodeBinding>(binding) {
    override fun bind(item: ItemUi, listener: (ItemUi) -> Unit) {
        val episode = item as EpisodeUi
        binding.apply {
            tvEpisodeName.text =
                root.context.getString(R.string.episode_info, episode.episode, episode.name)
            itemView.setOnClickListener {
                listener(episode)
            }
        }
    }
}