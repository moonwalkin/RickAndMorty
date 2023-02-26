package com.example.rickmorty.domain.models

open class ItemUi(val id: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemUi

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}