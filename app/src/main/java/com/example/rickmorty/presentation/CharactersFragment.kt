package com.example.rickmorty.presentation

import com.example.rickmorty.databinding.FragmentCharactersBinding

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)

}