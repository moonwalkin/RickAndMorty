package com.example.rickmorty.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.rickmorty.domain.Result

interface Communication<T> {

    fun observe(owner: LifecycleOwner, observer: Observer<Result<List<T>>>)

    fun show(listItem: Result<List<T>>)
}

