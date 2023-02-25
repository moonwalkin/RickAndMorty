package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.rickmorty.databinding.FragmentEpisodesBinding
import com.example.rickmorty.presentation.viewmodels.EpisodeViewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>() {
    private val viewModel: EpisodeViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentEpisodesBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it.results)
        }
    }
}