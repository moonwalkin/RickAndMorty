package com.example.rickmorty.domain.usecases

import com.example.rickmorty.domain.models.LocationUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class FetchAllLocationsUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): List<LocationUi> = repository.fetchLocations()
}