package com.example.andresenhomework6.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.andresenhomework6.databinding.ItemContactBinding
import com.example.andresenhomework6.domain.entity.Contact

class ContactsAdapter : ListAdapter<Contact, ContactViewHolder>(ContactDiffCallback()) {

    var onContactItemLongClickListener: ((Contact) -> Unit)? = null
    var onContactItemClickListener: ((Contact) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val viewHolder = ContactViewHolder.create(parent)
        viewHolder.itemView.setOnClickListener {
            onContactItemClickListener?.invoke(getItem(viewHolder.adapterPosition))
        }
        viewHolder.itemView.setOnLongClickListener {
            onContactItemLongClickListener?.invoke(getItem(viewHolder.adapterPosition))
            true
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}