package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.rickmorty.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentDetailsCharacterBinding
import com.example.rickmorty.presentation.viewmodels.CharacterViewModel
import com.example.rickmorty.domain.models.CharacterUi

class DetailsCharacterFragment : BaseFragment<FragmentDetailsCharacterBinding>(), HasCustomTitle {
    override fun getViewBinding() = FragmentDetailsCharacterBinding.inflate(layoutInflater)

    private val viewModel: CharacterViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchSingleCharacter(requireArguments().getInt(CHARACTER_ID))
        viewModel.observeSingleItem(viewLifecycleOwner) { character ->
            showDetails(character)
        }
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
        private const val CHARACTER_ID = "character_id"

        fun newInstance(id: Int) = DetailsCharacterFragment().apply {
            arguments = Bundle().apply {
                putInt(CHARACTER_ID, id)
            }
        }
    }


}