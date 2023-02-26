package com.example.rickmorty.domain.usecases

import com.example.rickmorty.data.ResponseLocations
import com.example.rickmorty.domain.RickMortyRepository
import javax.inject.Inject

class FetchAllLocationsUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): ResponseLocations = repository.fetchLocations()
}