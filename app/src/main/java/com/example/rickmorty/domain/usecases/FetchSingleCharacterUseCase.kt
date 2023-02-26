package com.example.rickmorty.domain.usecases

import com.example.rickmorty.domain.RickMortyRepository
import javax.inject.Inject
import com.example.rickmorty.data.Character

class FetchSingleCharacterUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(id: Int): Character = repository.fetchSingleCharacter(id)
}