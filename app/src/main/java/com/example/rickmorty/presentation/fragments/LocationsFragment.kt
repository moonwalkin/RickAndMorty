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
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.fetchListLocations()
        viewModel.observeListLocations(viewLifecycleOwner) { result ->
            show(binding.errorMessage, binding.progressBar, result)
        }
    }
}