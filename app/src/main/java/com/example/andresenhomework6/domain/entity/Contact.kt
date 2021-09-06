package com.example.andresenhomework6.domain.entity

data class Contact(
    val firstName: String,
    val lastName: String,
    val numberPhone: Long,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}