package com.example.afinal.repository

import androidx.lifecycle.LiveData
import com.example.afinal.data.SnackDao
import com.example.afinal.model.Snack

class SnackRepository(private val amSnackDao: SnackDao) {
    val amAllSnacks: LiveData<List<Snack>> = amSnackDao.amGetAllSnacks()

    suspend fun amInsert(snack: Snack) {
        amSnackDao.amInsertSnack(snack)
    }

    suspend fun amDeleteAll() {
        amSnackDao.amDeleteAll()
    }
}
