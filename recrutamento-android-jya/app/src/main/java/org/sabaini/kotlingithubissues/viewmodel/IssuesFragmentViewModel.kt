package org.sabaini.kotlingithubissues.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sabaini.kotlingithubissues.api.IssueResponse
import org.sabaini.kotlingithubissues.other.Resource
import org.sabaini.kotlingithubissues.repository.GithubIssuesRepository
import javax.inject.Inject

@HiltViewModel
class IssuesFragmentViewModel @Inject constructor(repository: GithubIssuesRepository) :
    ViewModel() {

    private val _issues = MutableLiveData<Resource<List<IssueResponse>>>()
    val issues: LiveData<Resource<List<IssueResponse>>> = _issues

    private val _navigateToSelectedIssue = MutableLiveData<IssueResponse?>()
    val navigateToSelectedIssue: MutableLiveData<IssueResponse?> = _navigateToSelectedIssue

    init {
        _issues.value = Resource.loading(null)
        viewModelScope.launch {
            val response = repository.getIssues()
            _issues.value = response
        }
    }

    fun displayIssueDetail(issue: IssueResponse) {
        _navigateToSelectedIssue.value = issue
    }

    fun displayIssueDetailComplete() {
        _navigateToSelectedIssue.value = null
    }
}