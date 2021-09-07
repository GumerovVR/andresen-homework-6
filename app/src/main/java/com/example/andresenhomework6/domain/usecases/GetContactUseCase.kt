package com.example.andresenhomework6.domain.usecases

import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.repository.ContactsRepository

class GetContactUseCase(
    private val contactsRepository: ContactsRepository) {

    fun getContact(contactId: Int): Contact {
        return contactsRepository.getContact(contactId)
    }
}