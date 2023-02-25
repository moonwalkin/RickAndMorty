package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.data.ResponseLocations
import com.example.rickmorty.domain.RickMortyRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    private val repository: RickMortyRepository
) : ViewModel() {

    val liveData = MutableLiveData<ResponseLocations>()

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch {
        liveData.value = repository.fetchLocations()
    }
}