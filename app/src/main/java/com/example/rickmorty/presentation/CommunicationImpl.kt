package com.example.rickmorty.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import javax.inject.Inject

class CommunicationImpl<T> @Inject constructor() : Communication<T> {

    private val singleItem = MutableLiveData<T>()
    private val listItems = MutableLiveData<List<T>>()

    override fun observeSingleItem(owner: LifecycleOwner, observer: Observer<T>) {
        singleItem.observe(owner, observer)
    }

    override fun observeListItems(owner: LifecycleOwner, observer: Observer<List<T>>) {
        listItems.observe(owner, observer)
    }

    override fun showItem(item: T) {
        singleItem.value = item!!
    }

    override fun showList(listItem: List<T>) {
        listItems.value = listItem
    }
}