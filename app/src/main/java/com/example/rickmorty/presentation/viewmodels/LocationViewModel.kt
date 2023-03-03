package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.domain.Result
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.usecases.FetchAllLocationsUseCase
import com.example.rickmorty.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    private val fetchAllLocationsUseCase: FetchAllLocationsUseCase,
    private val communication: Communication<LocationInfoUi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun fetchListLocations() = viewModelScope.launch(dispatcher) {
        communication.show(Result.Loading())
        communication.show(fetchAllLocationsUseCase())
    }

    fun observeListLocations(owner: LifecycleOwner, observer: Observer<Result<List<LocationInfoUi>>>) {
        communication.observe(owner, observer)
    }
}