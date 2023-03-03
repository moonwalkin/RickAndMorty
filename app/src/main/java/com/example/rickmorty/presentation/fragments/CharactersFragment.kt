package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.rickmorty.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.domain.Result
import com.example.rickmorty.databinding.FragmentCharactersBinding
import com.example.rickmorty.presentation.viewmodels.CharacterViewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding>(), HasCustomTitle {

    private val viewModel: CharacterViewModel by viewModels { factory }

    override fun getTitleRes() = R.string.title_characters
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.fetchListCharacters()
        viewModel.observeListItems(viewLifecycleOwner) { result ->
            show(binding.errorMessage, binding.progressBar, result)
        }
    }
}
