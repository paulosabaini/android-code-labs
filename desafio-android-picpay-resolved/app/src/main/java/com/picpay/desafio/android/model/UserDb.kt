package com.picpay.desafio.android.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DatabaseUser::class], version = 2)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}