package com.example.rickmorty.domain.usecases

import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject
import com.example.rickmorty.domain.models.CharacterUi

class FetchSingleCharacterUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(id: Int): CharacterUi = repository.fetchSingleCharacter(id)
}