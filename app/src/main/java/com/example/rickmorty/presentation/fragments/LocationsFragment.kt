package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rickmorty.databinding.FragmentLocationsBinding
import com.example.rickmorty.presentation.viewmodels.LocationViewModel

class LocationsFragment : BaseFragment<FragmentLocationsBinding>() {
    private val viewModel: LocationViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentLocationsBinding.inflate(layoutInflater)

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