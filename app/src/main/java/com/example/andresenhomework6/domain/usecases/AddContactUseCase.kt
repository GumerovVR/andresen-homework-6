package com.example.andresenhomework6.domain.usecases

import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.repository.ContactsRepository

class AddContactUseCase (
    private val contactsRepository: ContactsRepository) {

    fun addContact(contact: Contact) {
        contactsRepository.addContact(contact)
    }
}