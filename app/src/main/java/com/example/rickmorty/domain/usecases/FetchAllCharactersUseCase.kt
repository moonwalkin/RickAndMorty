package com.example.rickmorty.domain.usecases

import com.example.rickmorty.data.ResponseCharacters
import com.example.rickmorty.domain.RickMortyRepository
import javax.inject.Inject

class FetchAllCharactersUseCase @Inject constructor(private val repository: RickMortyRepository) {
    suspend operator fun invoke(): ResponseCharacters = repository.fetchCharacters()
}