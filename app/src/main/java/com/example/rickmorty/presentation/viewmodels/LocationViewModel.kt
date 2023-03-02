package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.domain.models.LocationInfoUi
import com.example.rickmorty.domain.usecases.FetchAllLocationsUseCase
import com.example.rickmorty.domain.usecases.FetchSingleLocationUseCase
import com.example.rickmorty.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LocationViewModel @Inject constructor(
    private val fetchAllLocationsUseCase: FetchAllLocationsUseCase,
    private val fetchSingleUseCase: FetchSingleLocationUseCase,
    private val communication: Communication<LocationInfoUi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {


    fun fetchListLocations() = viewModelScope.launch(dispatcher) {
        communication.showList(fetchAllLocationsUseCase())
    }

    fun fetchSingleLocation(id: Int) = viewModelScope.launch(dispatcher) {
        communication.showItem(fetchSingleUseCase(id))
    }

    fun observeSingleLocation(owner: LifecycleOwner, observer: Observer<LocationInfoUi>) {
        communication.observeSingleItem(owner, observer)
    }

    fun observeListLocations(owner: LifecycleOwner, observer: Observer<List<LocationInfoUi>>) {
        communication.observeListItems(owner, observer)
    }

}