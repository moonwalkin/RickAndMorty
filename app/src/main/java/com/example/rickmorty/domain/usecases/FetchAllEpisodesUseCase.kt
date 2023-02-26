package com.example.rickmorty.domain.usecases

import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class FetchAllEpisodesUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): List<EpisodeUi> = repository.fetchEpisodes()
}