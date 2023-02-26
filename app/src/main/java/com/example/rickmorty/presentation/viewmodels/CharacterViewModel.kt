package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.ResponseCharacters
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.rickmorty.data.Character

class CharacterViewModel @Inject constructor(private val repository: RickMortyRepository) :
    ViewModel() {

    val singleCharacter = MutableLiveData<Character>()
    val liveData = MutableLiveData<ResponseCharacters>()

    init {
        fetch()
    }


    fun fetchSingleCharacter(id: Int) = viewModelScope.launch {
        singleCharacter.value = repository.fetchSingleCharacter(id)
    }

    private fun fetch() = viewModelScope.launch {
        liveData.value = repository.fetchCharacters()
    }
}