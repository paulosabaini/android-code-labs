package com.picpay.desafio.android.api

import retrofit2.http.GET

interface PicPayService {

    @GET("users")
    suspend fun getUsers(): List<ApiUser>
}