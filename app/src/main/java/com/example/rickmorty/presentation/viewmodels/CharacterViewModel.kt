package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.usecases.FetchAllCharactersUseCase
import com.example.rickmorty.domain.usecases.FetchSingleCharacterUseCase
import com.example.rickmorty.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CharacterViewModel @Inject constructor(
    private val fetchAllCharactersUseCase: FetchAllCharactersUseCase,
    private val fetchSingleCharacterUseCase: FetchSingleCharacterUseCase,
    private val communication: Communication<CharacterUi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun fetchSingleCharacter(id: Int) = viewModelScope.launch(dispatcher) {
       communication.showItem(fetchSingleCharacterUseCase(id))
    }

    fun fetchListCharacters() = viewModelScope.launch(dispatcher) {
        communication.showList(fetchAllCharactersUseCase())
    }

    fun observeListItems(owner: LifecycleOwner, observer: Observer<List<CharacterUi>>) {
        communication.observeListItems(owner, observer)
    }

    fun observeSingleItem(owner: LifecycleOwner, observer: Observer<CharacterUi>) {
        communication.observeSingleItem(owner, observer)
    }
}