package org.sabaini.koinexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.sabaini.koinexample.entities.Cat

@Database(entities = [Cat::class], exportSchema = false, version = 1)
abstract class CatDatabase : RoomDatabase() {
    abstract fun catDao(): CatDao
}