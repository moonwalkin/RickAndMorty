package com.example.rickmorty.presentation

import com.example.rickmorty.databinding.FragmentLocationsBinding

class LocationsFragment : BaseFragment<FragmentLocationsBinding>() {
    override fun getViewBinding() = FragmentLocationsBinding.inflate(layoutInflater)
}