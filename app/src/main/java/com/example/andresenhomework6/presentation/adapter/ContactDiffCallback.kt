package com.example.andresenhomework6.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.andresenhomework6.domain.entity.Contact

class ContactDiffCallback: DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}