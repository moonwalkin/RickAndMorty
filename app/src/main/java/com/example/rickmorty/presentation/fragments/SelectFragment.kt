package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import com.example.rickmorty.presentation.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentSelectBinding
import com.example.rickmorty.presentation.navigate

class SelectFragment : BaseFragment<FragmentSelectBinding>(), HasCustomTitle {

    override fun getViewBinding() = FragmentSelectBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnCharacters.setOnClickListener {
                navigate().showCharacters()
            }
            btnEpisodes.setOnClickListener {
                navigate().showEpisodes()
            }
            btnLocations.setOnClickListener {
                navigate().showLocations()
            }
        }
    }

    override fun getTitleRes() = R.string.title_home

}