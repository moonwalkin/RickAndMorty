package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.domain.Result
import com.example.rickmorty.databinding.FragmentEpisodesBinding
import com.example.rickmorty.presentation.viewmodels.EpisodeViewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding>(), HasCustomTitle {
    private val viewModel: EpisodeViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentEpisodesBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getTitleRes() = R.string.title_episodes

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observeViewModel()
    }

    private fun initRecycler() {
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.fetchListEpisodes()
        viewModel.observeListEpisodes(viewLifecycleOwner) { result ->
            show(binding.errorMessage, binding.progressBar, result)
        }
    }

}