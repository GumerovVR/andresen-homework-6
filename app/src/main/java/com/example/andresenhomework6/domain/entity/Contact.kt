package com.example.andresenhomework6.domain.entity

import kotlin.random.Random

data class Contact(
    val firstName: String,
    val lastName: String,
    val numberPhone: Long,
    val image: String,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}