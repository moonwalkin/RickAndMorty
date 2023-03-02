package com.example.rickmorty.domain.usecases

import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class FetchAllLocationsUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): List<LocationInfoUi> = repository.fetchLocations()
}