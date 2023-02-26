package com.example.rickmorty.domain.usecases

import com.example.rickmorty.data.Episode
import com.example.rickmorty.domain.RickMortyRepository
import javax.inject.Inject

class FetchSingleEpisodeUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(id: Int): Episode = repository.fetchSingleEpisode(id)
}