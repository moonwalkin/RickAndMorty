package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        binding.recyclerView.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }
}