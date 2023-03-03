package com.example.rickmorty.domain.models

import java.io.Serializable


class LocationInfoUi(
    val dimension: String,
    id: Int,
    name: String,
    val type: String
): ItemUi(id, name), Serializable