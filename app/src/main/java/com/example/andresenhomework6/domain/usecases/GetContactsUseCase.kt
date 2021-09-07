package com.example.andresenhomework6.domain.usecases

import androidx.lifecycle.LiveData
import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.repository.ContactsRepository

class GetContactsUseCase(
    private val contactsRepository: ContactsRepository) {

    fun getContacts(): LiveData<List<Contact>> {
        return contactsRepository.getContacts()
    }
}