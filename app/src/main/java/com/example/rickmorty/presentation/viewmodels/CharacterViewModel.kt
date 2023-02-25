package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.ResponseCharacters
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(private val repository: RickMortyRepository) : ViewModel() {

    val liveData = MutableLiveData<ResponseCharacters>()

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch {
        liveData.value = repository.fetchCharacters()
    }
}