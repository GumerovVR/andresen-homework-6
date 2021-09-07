package com.example.andresenhomework6.domain.usecases

import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.repository.ContactsRepository

class DeleteContactUseCase(
    private val contactsRepository: ContactsRepository) {

    fun deleteContact(contact: Contact) {
        contactsRepository.deleteContact(contact)
    }
}