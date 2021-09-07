package com.example.andresenhomework6.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.andresenhomework6.databinding.FragmentDetailBinding
import com.example.andresenhomework6.domain.entity.Contact

class DetailFragment: Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailBinding == null")

    private var contactId: Int = Contact.UNDEFINED_ID
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.btnSaveEdit.setOnClickListener {
            viewModel.saveEditContact(
                binding.etName.text?.toString(),
                binding.etLastName.text?.toString(),
                binding.etPhoneNumber.text?.toString())
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)
            .get(DetailViewModel::class.java)
        viewModel.getContact(contactId)
        viewModel.contact.observe(viewLifecycleOwner, { contact ->
            contact?.let {
                binding.apply {
                    etName.setText(it.firstName)
                    etLastName.setText(it.lastName)
                    etPhoneNumber.setText(it.numberPhone.toString())
                }
            }

        })
    }

    private fun parseParams() {
        arguments?.let {
            contactId = it.getInt(CONTACT_ITEM_ID, Contact.UNDEFINED_ID)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val CONTACT_ITEM_ID = "extra_shop_item_id"

        fun newInstance(contactId: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(CONTACT_ITEM_ID, contactId)
                }
            }
        }
    }

}