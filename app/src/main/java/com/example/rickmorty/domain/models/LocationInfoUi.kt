package com.example.rickmorty.domain.models



class LocationInfoUi(
    val dimension: String,
    id: Int,
    name: String,
    val type: String
): ItemUi(id, name)