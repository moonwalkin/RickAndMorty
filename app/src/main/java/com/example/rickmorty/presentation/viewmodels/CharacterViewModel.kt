package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.R
import com.example.rickmorty.domain.Result
import com.example.rickmorty.domain.models.CharacterUi
import com.example.rickmorty.domain.usecases.FetchAllCharactersUseCase
import com.example.rickmorty.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val fetchAllCharactersUseCase: FetchAllCharactersUseCase,
    private val communication: Communication<CharacterUi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    init {
        fetchListCharacters()
    }

    fun fetchListCharacters() = viewModelScope.launch(dispatcher) {
        communication.show(fetchAllCharactersUseCase())
    }

    fun observeListItems(owner: LifecycleOwner, observer: Observer<Result<List<CharacterUi>>>) {
        communication.observe(owner, observer)
    }

    fun retry() {
        fetchListCharacters()
    }
}