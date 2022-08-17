package com.picpay.desafio.android.repository

import android.util.Log
import com.picpay.desafio.android.domain.User
import com.picpay.desafio.android.api.PicPayService
import com.picpay.desafio.android.api.asDatabaseModel
import com.picpay.desafio.android.model.UserDao
import com.picpay.desafio.android.model.asDomainModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PicPayRepository @Inject constructor(
    val userDao: UserDao,
    val userApi: PicPayService
) {

    fun getUsers(): Flow<List<User>> {
        val scope = CoroutineScope(Job() + Dispatchers.IO)
        scope.launch {
            refreshUsers()
        }
        return userDao.load().map {
            it.asDomainModel()
        }
    }

    private suspend fun refreshUsers() {
        withContext(Dispatchers.IO) {
            try {
                val users = userApi.getUsers()
                Log.d("teste", users.count().toString())
                userDao.save(users.asDatabaseModel())
            } catch (e: Exception) {
                Log.d("PicPayRepository", e.toString())
            }
        }
    }
}