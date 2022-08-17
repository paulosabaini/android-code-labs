package com.picpay.desafio.android.api

import com.picpay.desafio.android.model.DatabaseUser

data class ApiUser(
    val id: Int,
    val img: String,
    val name: String,
    val username: String
)

fun List<ApiUser>.asDatabaseModel(): List<DatabaseUser> {
    return map {
        DatabaseUser(
            id = it.id,
            img = it.img,
            name = it.name,
            username = it.username
        )
    }
}