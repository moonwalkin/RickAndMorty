package com.example.rickmorty.presentation

import android.os.Bundle
import android.view.View
import com.example.rickmorty.databinding.FragmentSelectBinding
import com.example.rickmorty.navigate

class SelectFragment : BaseFragment<FragmentSelectBinding>() {

    override fun getViewBinding() = FragmentSelectBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCharacters.setOnClickListener {
            navigate().showCharacters()
        }
        binding.btnEpisodes.setOnClickListener {
            navigate().showEpisodes()
        }
        binding.btnLocations.setOnClickListener {
            navigate().showLocations()
        }
    }
}