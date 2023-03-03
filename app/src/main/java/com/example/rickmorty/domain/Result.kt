package com.example.rickmorty.domain

sealed class Result<T> {
    class Success<T>(val data: T): Result<T>()
    class Loading<T> : Result<T>()
    class Error<T>(val exception: Exception): Result<T>()
}