package com.example.rickmorty.data

import com.example.rickmorty.domain.NoConnectionException
import com.example.rickmorty.domain.ServiceUnavailableException
import java.net.UnknownHostException
import javax.inject.Inject

interface ResultHandler {
    suspend fun <T> handle(body: suspend () -> T): T

    class Base @Inject constructor() : ResultHandler {
        override suspend fun <T> handle(body: suspend () -> T): T {
            return try {
                body()
            } catch (e: Exception) {
                if (e is UnknownHostException) {
                    throw NoConnectionException()
                } else {
                    throw ServiceUnavailableException()
                }
            }
        }
    }
}