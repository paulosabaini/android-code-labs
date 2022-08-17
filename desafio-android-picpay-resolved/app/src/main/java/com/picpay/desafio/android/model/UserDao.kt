package com.picpay.desafio.android.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(users: List<DatabaseUser>)

    @Query("select * from databaseuser")
    fun load(): Flow<List<DatabaseUser>>
}