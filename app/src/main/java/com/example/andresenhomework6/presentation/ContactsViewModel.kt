package com.example.andresenhomework6.presentation

import androidx.lifecycle.ViewModel
import com.example.andresenhomework6.data.ContactsRepositoryImpl
import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.usecases.DeleteContactUseCase
import com.example.andresenhomework6.domain.usecases.EditContactUseCase
import com.example.andresenhomework6.domain.usecases.GetContactsUseCase

class ContactsViewModel : ViewModel() {

    private val repository = ContactsRepositoryImpl

    private val getContactsUseCase = GetContactsUseCase(repository)
    private val deleteContactUseCase = DeleteContactUseCase(repository)
    private val editContactUseCase = EditContactUseCase(repository)

    val contactsList = getContactsUseCase.getContacts()

    fun deleteShopItem(contact: Contact) {
        deleteContactUseCase.deleteContact(contact)
    }
}