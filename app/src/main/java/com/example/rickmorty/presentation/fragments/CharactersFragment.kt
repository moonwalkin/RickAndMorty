package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickmorty.presentation.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentCharactersBinding
import com.example.rickmorty.presentation.ScrollListener
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
        binding.tryButton.setOnClickListener {
            viewModel.retry()
        }
        initRecycler()
        observeViewModel()
    }


    private fun initRecycler() {
        val layoutManager = GridLayoutManager(context, 3)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addOnScrollListener(ScrollListener({
            viewModel.fetchListCharacters()
        }, layoutManager))
        binding.recyclerView.layoutManager = layoutManager
    }

    private fun observeViewModel() {
        viewModel.observeListItems(viewLifecycleOwner) { result ->
            binding.apply {
                show(recyclerView, progressBar, tvErrorMessage, tryButton, result)
            }
        }
    }
}
