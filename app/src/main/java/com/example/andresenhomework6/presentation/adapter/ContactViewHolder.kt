package com.example.andresenhomework6.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.andresenhomework6.databinding.ItemContactBinding
import com.example.andresenhomework6.domain.entity.Contact

class ContactViewHolder(private val binding: ItemContactBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(contact: Contact) {
        with(binding) {
            tvFirstName.text = contact.firstName
            tvLastName.text = contact.lastName
            tvPhoneNumber.text = contact.numberPhone.toString()
        }
    }

    companion object{
        fun create(parent: ViewGroup): ContactViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemContactBinding.inflate(inflater, parent, false)
            return ContactViewHolder(binding)
        }
    }
}