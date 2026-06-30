package com.example.afinal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.afinal.model.Snack

@Database(entities = [Snack::class], version = 1, exportSchema = false)
abstract class SnackRoomDatabase : RoomDatabase() {

    abstract fun amSnackDao(): SnackDao

    companion object {
        @Volatile
        private var amINSTANCE: SnackRoomDatabase? = null

        fun amGetDatabase(context: Context): SnackRoomDatabase {
            return amINSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SnackRoomDatabase::class.java,
                    "snack_database"
                ).build()
                amINSTANCE = instance
                instance
            }
        }
    }
}
