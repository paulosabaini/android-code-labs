package org.sabaini.koinexample.data.remote

import org.sabaini.koinexample.entities.Cat
import retrofit2.http.GET

interface CatApi {

    @GET("catapi/rest/")
    suspend fun getCat(): Cat
}