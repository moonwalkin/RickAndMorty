package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentDetailsEpisodeBinding
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.presentation.viewmodels.EpisodeViewModel

class DetailsEpisodeFragment : BaseFragment<FragmentDetailsEpisodeBinding>() {

    private val viewModel: EpisodeViewModel by viewModels { factory }

    override fun getViewBinding() = FragmentDetailsEpisodeBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchSingleEpisode(requireArguments().getInt(EPISODE_ID))
        viewModel.observeSingleEpisode(viewLifecycleOwner) { episode ->
            showDetails(episode)
        }
    }

    private fun showDetails(episode: EpisodeUi) {
        binding.apply {
            tvEpisode.text = getString(R.string.episode, episode.episode)
            tvEpisodeName.text = getString(R.string.episode_name, episode.name)
            tvAirDate.text = getString(R.string.episode_air_date, episode.air_date)
        }
    }

    companion object {
        private const val EPISODE_ID = "episode_id"

        fun newInstance(id: Int) = DetailsEpisodeFragment().apply {
            arguments = Bundle().apply {
                putInt(EPISODE_ID, id)
            }
        }
    }
}