package com.example.rickmorty.domain.usecases

import com.example.rickmorty.data.LocationInfo
import com.example.rickmorty.domain.RickMortyRepository

class FetchSingleLocationUseCase(private val repository: RickMortyRepository) {
    suspend operator fun invoke(id: Int): LocationInfo = repository.fetchSingleLocation(id)
}