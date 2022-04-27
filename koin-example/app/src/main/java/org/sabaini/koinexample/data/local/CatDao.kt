package org.sabaini.koinexample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.sabaini.koinexample.entities.Cat

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(cat: Cat)

    @Query("select * from Cat order by localId desc limit 1")
    fun load(): Flow<Cat>

    @Query("delete from Cat")
    fun delete()
}