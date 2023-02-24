package com.example.rickmorty.presentation

import com.example.rickmorty.databinding.FragmentEpisodesBinding

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>() {
    override fun getViewBinding() = FragmentEpisodesBinding.inflate(layoutInflater)
}