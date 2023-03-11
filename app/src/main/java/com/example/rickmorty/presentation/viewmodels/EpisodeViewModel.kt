package com.example.rickmorty.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickmorty.domain.Result
import com.example.rickmorty.domain.models.EpisodeUi
import com.example.rickmorty.domain.usecases.FetchAllEpisodesUseCase
import com.example.rickmorty.presentation.Communication
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    private val fetchAllEpisodesUseCase: FetchAllEpisodesUseCase,
    private val communication: Communication<EpisodeUi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    init {
        fetchListEpisodes()
    }

    fun fetchListEpisodes() = viewModelScope.launch(dispatcher) {
        communication.show(fetchAllEpisodesUseCase())
    }

    fun observeListEpisodes(owner: LifecycleOwner, observer: Observer<Result<List<EpisodeUi>>>) {
        communication.observe(owner, observer)
    }

    fun retry() {
        fetchListEpisodes()
    }
}