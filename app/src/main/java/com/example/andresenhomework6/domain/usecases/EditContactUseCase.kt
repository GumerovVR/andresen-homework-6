package com.example.andresenhomework6.domain.usecases

import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.repository.ContactsRepository

class EditContactUseCase (private val contactsRepository: ContactsRepository) {
    fun editContact(contact: Contact) {
        contactsRepository.editContact(contact)
    }
}