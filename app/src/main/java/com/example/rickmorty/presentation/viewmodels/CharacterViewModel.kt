package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.usecases.FetchAllCharactersUseCase
import com.example.rickmorty.domain.usecases.FetchSingleCharacterUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CharacterViewModel @Inject constructor(
    private val fetchAllCharactersUseCase: FetchAllCharactersUseCase,
    private val fetchSingleCharacterUseCase: FetchSingleCharacterUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) :
    ViewModel() {

    val singleCharacter = MutableLiveData<CharacterUi>()
    val liveData = MutableLiveData<List<CharacterUi>>()

    init {
        fetch()
    }


    fun fetchSingleCharacter(id: Int) = viewModelScope.launch(dispatcher) {
        singleCharacter.value = fetchSingleCharacterUseCase(id)
    }

    private fun fetch() = viewModelScope.launch(dispatcher) {
        liveData.value = fetchAllCharactersUseCase()
    }

}