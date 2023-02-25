package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.rickmorty.databinding.FragmentSelectBinding
import com.example.rickmorty.navigate
import com.example.rickmorty.presentation.viewmodels.CharacterViewModel

class SelectFragment : BaseFragment<FragmentSelectBinding>() {
    override val viewModel: CharacterViewModel by viewModels { factory }

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