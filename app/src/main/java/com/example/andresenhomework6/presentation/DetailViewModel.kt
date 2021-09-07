package com.example.andresenhomework6.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andresenhomework6.data.ContactsRepositoryImpl
import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.domain.usecases.EditContactUseCase
import com.example.andresenhomework6.domain.usecases.GetContactUseCase

class DetailViewModel : ViewModel() {

    private val repository = ContactsRepositoryImpl

    private val getContactUseCase = GetContactUseCase(repository)
    private val editContactUseCase = EditContactUseCase(repository)

    private val _contact = MutableLiveData<Contact>()
    val contact: LiveData<Contact>
        get() = _contact

    fun getContact(contactId: Int) {
        val item = getContactUseCase.getContact(contactId)
        _contact.value = item
    }

    fun saveEditContact(inputName: String?, inputLastName: String?, inputNumberPhone: String?) {
        _contact.value?.let {
            val item = inputName?.let { it1 ->
                inputLastName?.let { it2 ->
                    inputNumberPhone?.toLong()?.let { it3 ->
                        it.copy(
                            firstName = it1,
                            lastName = it2,
                            numberPhone = it3
                        )
                    }
                }
            }
            if (item != null) {
                editContactUseCase.editContact(item)
            }
        }

    }


}