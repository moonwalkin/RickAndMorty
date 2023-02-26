package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.ResponseEpisodes
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val repository: RickMortyRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {
    val liveData = MutableLiveData<ResponseEpisodes>()


    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch(dispatcher) {
        liveData.value = repository.fetchEpisodes()
    }
}