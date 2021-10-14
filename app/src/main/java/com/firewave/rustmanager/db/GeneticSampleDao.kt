package com.firewave.rustmanager.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.firewave.rustmanager.genetics.GeneticSample

@Dao
interface GeneticSampleDao {
    @Query("SELECT * FROM geneticSample")
    fun getAll(): List<GeneticSample>

    @Query("SELECT * FROM geneticSample WHERE serverId = serverId")
    fun getAllForServer(serverId:Int)

    @Delete
    fun delete(user: GeneticSample)
}