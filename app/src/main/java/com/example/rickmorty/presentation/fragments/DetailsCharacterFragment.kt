package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.rickmorty.presentation.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentDetailsCharacterBinding
import com.example.rickmorty.domain.models.CharacterUi

class DetailsCharacterFragment : BaseFragment<FragmentDetailsCharacterBinding>(), HasCustomTitle {
    override fun getViewBinding() = FragmentDetailsCharacterBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = requireArguments().getSerializable(CHARACTER) as CharacterUi
        showDetails(character)
    }

    private fun showDetails(character: CharacterUi) {
        binding.apply {
            tvName.text = getString(R.string.character_name, character.name)
            tvGender.text = getString(R.string.character_gender, character.gender)
            tvStatus.text = getString(R.string.character_status, character.status)
            tvSpecies.text = getString(R.string.character_species, character.species)
            tvLocation.text = getString(R.string.character_location, character.location.name)
            Glide.with(requireContext()).load(character.image).circleCrop().into(ivCharacter)
        }
    }

    override fun getTitleRes() = R.string.title_character_details

    companion object {
        private const val CHARACTER = "character"

        fun newInstance(character: CharacterUi) = DetailsCharacterFragment().apply {
            arguments = Bundle().apply {
                putSerializable(CHARACTER, character)
            }
        }
    }


}