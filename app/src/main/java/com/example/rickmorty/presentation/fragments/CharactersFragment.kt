package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.rickmorty.databinding.FragmentCharactersBinding
import com.example.rickmorty.presentation.viewmodels.CharacterViewModel
import com.example.rickmorty.presentation.RickMortyAdapter

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {

    override val viewModel: CharacterViewModel by viewModels { factory }
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RickMortyAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it.results)
        }
    }
}