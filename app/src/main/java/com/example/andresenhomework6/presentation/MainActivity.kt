package com.example.andresenhomework6.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andresenhomework6.R
import com.example.andresenhomework6.presentation.fragments.contacts.ContactsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tablet = isTabletMode()
        launchFragment(ContactsFragment.newInstance(tablet), R.id.main_container)
    }

    private fun launchFragment(fragment: Fragment, container: Int) {
        supportFragmentManager.beginTransaction()
            .replace(container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun isTabletMode() : Boolean {
        val secondContainer = findViewById<View>(R.id.second_container)
        return secondContainer != null
    }

}