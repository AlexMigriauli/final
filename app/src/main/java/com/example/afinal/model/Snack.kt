package com.example.afinal.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "snack_table")
data class Snack(
    @PrimaryKey(autoGenerate = true)
    val amId: Int = 0,
    val amName: String,
    val amPrice: Double,
    val amDescription: String
)
