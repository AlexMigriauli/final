package com.example.afinal.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.afinal.model.Snack

@Dao
interface SnackDao {
    @Query("SELECT * FROM snack_table ORDER BY amName ASC")
    fun amGetAllSnacks(): LiveData<List<Snack>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun amInsertSnack(snack: Snack)

    @Query("DELETE FROM snack_table")
    suspend fun amDeleteAll()
}
