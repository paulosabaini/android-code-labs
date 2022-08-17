package org.sabaini.kotlingithubissues.repository

import android.util.Log
import org.sabaini.kotlingithubissues.api.GithubIssuesAPI
import org.sabaini.kotlingithubissues.api.IssueResponse
import org.sabaini.kotlingithubissues.other.Resource
import javax.inject.Inject

class GithubIssuesRepository @Inject constructor(private val githubIssuesAPI: GithubIssuesAPI) {

    suspend fun getIssues(): Resource<List<IssueResponse>> {
        return try {
            val response = githubIssuesAPI.getIssues()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occured", null)
            } else {
                Resource.error("An unknown error occured", null)
            }
        } catch (e: Exception) {
            Log.e("EXCEPTION", "EXCEPTION:", e)
            Resource.error("Couldn't reach the server. Check your internet connection", null)
        }
    }
}