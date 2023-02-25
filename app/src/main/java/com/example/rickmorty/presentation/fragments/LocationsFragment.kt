package com.example.rickmorty.presentation.fragments

import androidx.fragment.app.viewModels
import com.example.rickmorty.databinding.FragmentLocationsBinding
import com.example.rickmorty.presentation.viewmodels.LocationViewModel

class LocationsFragment : BaseFragment<FragmentLocationsBinding>() {
    override val viewModel: LocationViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentLocationsBinding.inflate(layoutInflater)
}