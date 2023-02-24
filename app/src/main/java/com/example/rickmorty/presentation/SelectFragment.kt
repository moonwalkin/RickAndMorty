package com.example.rickmorty.presentation

import android.os.Bundle
import android.view.View
import com.example.rickmorty.databinding.FragmentSelectBinding

class SelectFragment : BaseFragment<FragmentSelectBinding>() {

    override fun getViewBinding() = FragmentSelectBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCharacters.setOnClickListener {

        }
        binding.btnEpisodes.setOnClickListener {

        }
        binding.btnLocations.setOnClickListener {

        }
    }
}