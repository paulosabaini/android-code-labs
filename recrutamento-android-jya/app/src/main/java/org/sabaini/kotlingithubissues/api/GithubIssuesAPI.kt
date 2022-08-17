package org.sabaini.kotlingithubissues.api

import retrofit2.Response
import retrofit2.http.GET

interface GithubIssuesAPI {

    @GET("repos/JetBrains/kotlin/issues")
    suspend fun getIssues(): Response<List<IssueResponse>>
}