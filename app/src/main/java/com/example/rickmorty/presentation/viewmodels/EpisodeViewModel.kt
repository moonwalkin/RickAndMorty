package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.usecases.FetchAllEpisodesUseCase
import com.example.rickmorty.domain.usecases.FetchSingleEpisodeUseCase
import com.example.rickmorty.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val fetchAllEpisodesUseCase: FetchAllEpisodesUseCase,
    private val fetchSingleEpisodeUseCase: FetchSingleEpisodeUseCase,
    private val communication: Communication<EpisodeUi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    fun fetchSingleEpisode(id: Int) = viewModelScope.launch(dispatcher) {
        communication.showItem(fetchSingleEpisodeUseCase(id))
    }

    fun fetchListEpisodes() = viewModelScope.launch(dispatcher) {
        communication.showList(fetchAllEpisodesUseCase())
    }

    fun observeSingleEpisode(owner: LifecycleOwner, observer: Observer<EpisodeUi>) =
        viewModelScope.launch {
            communication.observeSingleItem(owner, observer)
        }

    fun observeListEpisodes(owner: LifecycleOwner, observer: Observer<List<EpisodeUi>>) {
        communication.observeListItems(owner, observer)
    }

}