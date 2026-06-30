package com.example.afinal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.SnackRoomDatabase
import com.example.afinal.model.Snack
import com.example.afinal.repository.SnackRepository
import kotlinx.coroutines.launch

class SnackViewModel(application: Application) : AndroidViewModel(application) {
    private val amRepository: SnackRepository
    val amAllSnacks: LiveData<List<Snack>>

    init {
        val snackDao = SnackRoomDatabase.amGetDatabase(application).amSnackDao()
        amRepository = SnackRepository(snackDao)
        amAllSnacks = amRepository.amAllSnacks
    }

    fun amInsert(snack: Snack) = viewModelScope.launch {
        amRepository.amInsert(snack)
    }

    fun amDeleteAll() = viewModelScope.launch {
        amRepository.amDeleteAll()
    }
}
