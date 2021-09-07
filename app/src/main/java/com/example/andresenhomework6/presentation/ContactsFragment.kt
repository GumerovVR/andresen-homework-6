package com.example.andresenhomework6.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.andresenhomework6.R
import com.example.andresenhomework6.databinding.FragmentContactsBinding
import com.example.andresenhomework6.domain.entity.Contact
import com.example.andresenhomework6.presentation.adapter.ContactsAdapter

class ContactsFragment : Fragment() {

    private var _binding: FragmentContactsBinding? = null
    private val binding: FragmentContactsBinding
        get() = _binding ?: throw RuntimeException("FragmentContactsBinding == null")

    private lateinit var viewModel: ContactsViewModel
    private lateinit var contactAdapter: ContactsAdapter
    private var isTabletMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactsBinding.inflate(inflater, container, false)
        setupRecyclerView()
        viewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)
        viewModel.contactsList.observe(viewLifecycleOwner) {
            contactAdapter.submitList(it)
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun launchFragment(fragment: Fragment, container: Int) {
        parentFragmentManager.beginTransaction()
            .replace(container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setupRecyclerView() {
        with(binding.rvContactsList) {
            contactAdapter = ContactsAdapter()
            adapter = contactAdapter
        }
        setupClickListener()
    }

    private fun parseParams() {
        arguments?.let {
            isTabletMode = it.getBoolean(EXTRA_TABLET_MODE, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupClickListener() {
        contactAdapter.onContactItemClickListener = {
            if (isTabletMode) {
                launchFragment(DetailFragment.newInstance(it.id), R.id.second_container)
            } else {
                launchFragment(DetailFragment.newInstance(it.id), R.id.main_container)
            }
        }
    }

    private fun setupLongClickListener() {
        TODO("УДАЛЕНИЕ")
    }

    companion object {
        private const val EXTRA_TABLET_MODE = "extra_tablet_mode"

        fun newInstance(isTabletMode: Boolean): ContactsFragment {
            return ContactsFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(EXTRA_TABLET_MODE, isTabletMode)
                }
            }
        }
    }
}