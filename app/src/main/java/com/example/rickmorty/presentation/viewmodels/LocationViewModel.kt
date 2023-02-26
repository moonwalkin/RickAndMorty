package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.domain.models.LocationUi
import com.example.rickmorty.domain.usecases.FetchAllLocationsUseCase
import com.example.rickmorty.domain.usecases.FetchSingleLocationUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    private val fetchAllLocationsUseCase: FetchAllLocationsUseCase,
    private val fetchSingleUseCase: FetchSingleLocationUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    val liveData = MutableLiveData<List<LocationUi>>()
    val singleLocation = MutableLiveData<LocationUi>()

    init {
        fetch()
    }

    private fun fetch() = viewModelScope.launch(dispatcher) {
        liveData.value = fetchAllLocationsUseCase()
    }

    fun fetchSingleLocation(id: Int) = viewModelScope.launch(dispatcher) {
        singleLocation.value = fetchSingleUseCase(id)
    }
}