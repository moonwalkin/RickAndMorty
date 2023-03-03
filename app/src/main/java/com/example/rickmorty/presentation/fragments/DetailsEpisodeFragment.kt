package com.example.rickmorty.presentation.fragments

import android.os.Bundle
import android.view.View
import com.example.rickmorty.HasCustomTitle
import com.example.rickmorty.R
import com.example.rickmorty.databinding.FragmentDetailsEpisodeBinding
import com.example.rickmorty.domain.models.EpisodeUi

class DetailsEpisodeFragment : BaseFragment<FragmentDetailsEpisodeBinding>(), HasCustomTitle {

    override fun getViewBinding() = FragmentDetailsEpisodeBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val episode = requireArguments().getSerializable(EPISODE) as EpisodeUi
        showDetails(episode)
    }

    private fun showDetails(episode: EpisodeUi) {
        binding.apply {
            tvEpisode.text = getString(R.string.episode, episode.episode)
            tvEpisodeName.text = getString(R.string.episode_name, episode.name)
            tvAirDate.text = getString(R.string.episode_air_date, episode.air_date)
        }
    }

    override fun getTitleRes() = R.string.title_episode_details

    companion object {
        private const val EPISODE = "episode"

        fun newInstance(episode: EpisodeUi) = DetailsEpisodeFragment().apply {
            arguments = Bundle().apply {
                putSerializable(EPISODE, episode)
            }
        }
    }

}