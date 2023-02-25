package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.ResponseEpisodes
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(private val repository: RickMortyRepository) : ViewModel() {
    val liveData = MutableLiveData<ResponseEpisodes>()


    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch {
        liveData.value = repository.fetchEpisodes()
    }
}