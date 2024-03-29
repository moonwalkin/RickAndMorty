package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickmorty.presentation.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentLocationsBinding
import com.example.rickmorty.presentation.viewmodels.LocationViewModel

class LocationsFragment : BaseFragment<FragmentLocationsBinding>(), HasCustomTitle {
    private val viewModel: LocationViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentLocationsBinding.inflate(layoutInflater)

    override fun getTitleRes() = R.string.title_locations

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        observeViewModel()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager
        adapter.onScroll = { viewModel.fetchListLocations() }
        binding.tryButton.setOnClickListener {
            viewModel.retry()
        }
    }

    private fun observeViewModel() {
        viewModel.observeListLocations(viewLifecycleOwner) { result ->
            binding.apply {
                show(recyclerView, progressBar, tvErrorMessage, tryButton, result)
            }
        }
    }
}