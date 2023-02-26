package com.example.rickmorty.domain.usecases

import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class FetchAllCharactersUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): List<CharacterUi> = repository.fetchCharacters()
}