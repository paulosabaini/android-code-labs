package org.sabaini.koinexample.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cat(
    @PrimaryKey(autoGenerate = true)
    val localId: Long,
    val id: Long,
    val url: String,
    val x: Double,
    val y: Double
)