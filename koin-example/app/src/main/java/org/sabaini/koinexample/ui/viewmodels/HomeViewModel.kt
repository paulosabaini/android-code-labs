package org.sabaini.koinexample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import org.sabaini.koinexample.entities.Cat
import org.sabaini.koinexample.repositories.CatRepository

class HomeViewModel(repository: CatRepository) : ViewModel() {

    private var _cat = MutableLiveData<Cat>()
    val cat: LiveData<Cat>
        get() = _cat

    init {
        _cat = repository.getCat().asLiveData() as MutableLiveData<Cat>
    }
}