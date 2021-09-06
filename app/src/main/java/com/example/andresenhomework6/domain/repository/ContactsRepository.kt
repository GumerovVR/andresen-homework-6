package com.example.andresenhomework6.domain.repository

import androidx.lifecycle.LiveData
import com.example.andresenhomework6.domain.entity.Contact

interface ContactsRepository {

    fun deleteContact(contact: Contact)

    fun getContacts(): LiveData<List<Contact>>

    fun getContact(contactId: Int): Contact
}