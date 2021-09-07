package com.example.andresenhomework6.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.repository.ContactsRepository

object ContactsRepositoryImpl : ContactsRepository {

    private val contactsListLD = MutableLiveData<List<Contact>>()
    private val contactsList = sortedSetOf<Contact>(
        { o1, o2 -> o1.id.compareTo(o2.id) })
    private val firstNamesList =
        listOf("Артем", "Владислав", "Егор", "Ержан", "Антон",
            "Петр", "Ян", "Федор", "Максим", "Данил", "Александр",
            "Николай", "Вадим", "Роман")
    private val lastNamesList =
        listOf("Иванов", "Петров", "Ивакин", "Тихомиров",
            "Грузнев", "Батутин", "Носков", "Рубалёв", "Герасимов")

    private var autoIncrementId = 0

    // хардкод добавление контактов
    init {
        for (i in 0 until 100) {
            val item = Contact(
                firstNamesList.random(),
                lastNamesList.random(),
                (89000000000 + (Math.random() * 999999999)).toLong()
            )
            addContact(item)
        }
    }

    override fun editContact(contact: Contact) {
        val oldElement = getContact(contact.id)
        contactsList.remove(oldElement)
        addContact(contact)
    }

    override fun addContact(contact: Contact) {
        if (contact.id == Contact.UNDEFINED_ID) {
            contact.id = autoIncrementId++
        }
        contactsList.add(contact)
        updateContacts()
    }

    override fun deleteContact(contact: Contact) {
        contactsList.remove(contact)
        updateContacts()
    }

    override fun getContacts(): LiveData<List<Contact>> {
        return contactsListLD
    }

    override fun getContact(contactId: Int): Contact {
        return contactsList.find {
            it.id == contactId
        } ?: throw RuntimeException("Contact with id $contactId not found")
    }

    private fun updateContacts() {
        contactsListLD.value = contactsList.toList()
    }


}