package com.firewave.rustmanager.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.firewave.rustmanager.genetics.Gene
import com.firewave.rustmanager.genetics.GeneticSample

@Database(entities = arrayOf(GeneticSample::class, Gene::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun geneticSampeDao(): GeneticSampleDao

    fun getDatabase(context: Context) : AppDatabase {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "rustmanager_db"
        ).build()
        return db
    }
}