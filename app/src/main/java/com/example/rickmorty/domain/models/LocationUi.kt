package com.example.rickmorty.domain.models



class LocationUi(
    val dimension: String,
    id: Int,
    val name: String,
    val type: String
): ItemUi(id)