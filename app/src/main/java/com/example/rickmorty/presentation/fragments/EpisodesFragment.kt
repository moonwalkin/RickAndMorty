package com.example.rickmorty.presentation.fragments

import androidx.fragment.app.viewModels
import com.example.rickmorty.databinding.FragmentEpisodesBinding
import com.example.rickmorty.presentation.viewmodels.EpisodeViewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>() {
    private val viewModel: EpisodeViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentEpisodesBinding.inflate(layoutInflater)
}