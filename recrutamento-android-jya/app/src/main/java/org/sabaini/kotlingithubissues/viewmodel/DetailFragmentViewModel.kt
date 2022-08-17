package org.sabaini.kotlingithubissues.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sabaini.kotlingithubissues.api.IssueResponse
import javax.inject.Inject

@HiltViewModel
class DetailFragmentViewModel @Inject constructor() : ViewModel() {

    private val _selectedIssue = MutableLiveData<IssueResponse>()
    val selectedIssue: LiveData<IssueResponse> = _selectedIssue

    fun setSelectedIssue(issue: IssueResponse) {
        _selectedIssue.value = issue
    }


}