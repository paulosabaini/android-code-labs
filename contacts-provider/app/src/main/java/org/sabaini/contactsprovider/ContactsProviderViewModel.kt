package org.sabaini.contactsprovider

import android.content.ContentResolver
import android.database.Cursor
import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactsProviderViewModel(private val contentResolver: ContentResolver) : ViewModel() {

    private val projection: Array<String> = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    )

    private val _cursor = MutableLiveData<Cursor>()
    val cursor: LiveData<Cursor>
        get() = _cursor

    fun readContacts() {
        _cursor.value = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
    }

    fun filterContacts(text: String) {
        _cursor.value = contentResolver.query (
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
            arrayOf("%$text%"),
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
    }

    class Factory(val contentResolver: ContentResolver) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContactsProviderViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ContactsProviderViewModel(contentResolver) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}