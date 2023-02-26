package com.example.rickmorty.domain.usecases

import com.example.rickmorty.data.ResponseEpisodes
import com.example.rickmorty.domain.RickMortyRepository
import javax.inject.Inject

class FetchAllEpisodesUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): ResponseEpisodes = repository.fetchEpisodes()
}