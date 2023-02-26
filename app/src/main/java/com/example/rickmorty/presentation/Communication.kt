package com.example.rickmorty.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface Communication<T> {

    fun observeSingleItem(owner: LifecycleOwner, observer: Observer<T>)

    fun observeListItems(owner: LifecycleOwner, observer: Observer<List<T>>)

    fun showItem(item: T)

    fun showList(listItem: List<T>)
}

