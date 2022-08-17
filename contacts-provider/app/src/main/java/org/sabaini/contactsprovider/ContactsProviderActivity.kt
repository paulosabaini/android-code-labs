package org.sabaini.contactsprovider

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.sabaini.contactsprovider.databinding.ActivityContactsProviderBinding

class ContactsProviderActivity : AppCompatActivity() {

    private val viewModel: ContactsProviderViewModel by lazy {
        ViewModelProvider(this, ContactsProviderViewModel.Factory(contentResolver)).get(
            ContactsProviderViewModel::class.java
        )
    }

    private lateinit var binding: ActivityContactsProviderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsProviderBinding.inflate(layoutInflater)
        val view = binding.root

        requestPermission()

        viewModel.cursor.observe(this, Observer {
            val columns: Array<String> = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
            )

            val items = intArrayOf(android.R.id.text1, android.R.id.text2)

            val cursorAdapter = SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                it,
                columns,
                items,
                0
            )

            binding.listView.adapter = cursorAdapter
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterContacts(newText!!)
                return false
            }

        })

        setContentView(view)
    }

    private fun requestPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            viewModel.readContacts()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 111)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            111 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    viewModel.readContacts()
                }
            }
        }
    }
}