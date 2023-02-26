package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.ResponseCharacters
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.rickmorty.data.Character
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CharacterViewModel @Inject constructor(
    private val repository: RickMortyRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) :
    ViewModel() {

    val singleCharacter = MutableLiveData<Character>()
    val liveData = MutableLiveData<ResponseCharacters>()

    init {
        fetch()
    }


    fun fetchSingleCharacter(id: Int) = viewModelScope.launch(dispatcher) {
        singleCharacter.value = repository.fetchSingleCharacter(id)
    }

    private fun fetch() = viewModelScope.launch(dispatcher) {
        liveData.value = repository.fetchCharacters()
    }

}