package com.example.rickmorty.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.rickmorty.domain.Result
import javax.inject.Inject

class CommunicationImpl<T> @Inject constructor() : Communication<T> {

    private val listItems = MutableLiveData<Result<List<T>>>()

    override fun observe(owner: LifecycleOwner, observer: Observer<Result<List<T>>>) {
        listItems.observe(owner, observer)
    }

    override fun show(listItem: Result<List<T>>) {
        listItems.value = listItem
    }
}