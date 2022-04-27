package org.sabaini.koinexample.repositories

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import org.sabaini.koinexample.entities.Cat
import org.sabaini.koinexample.data.local.CatDao
import org.sabaini.koinexample.data.remote.CatApi

class CatRepository(private val dao: CatDao, private val api: CatApi) {

    fun getCat(): Flow<Cat> {
        val scope = CoroutineScope(Job() + Dispatchers.IO)
        scope.launch {
            refreshCat()
        }
        return dao.load()
    }

    private suspend fun refreshCat() {
        withContext(Dispatchers.IO) {
            try {
                val response = api.getCat()
                dao.save(response)
            } catch (e: Exception) {
                Log.d("CatRepository", e.stackTraceToString())
            }
        }
    }
}