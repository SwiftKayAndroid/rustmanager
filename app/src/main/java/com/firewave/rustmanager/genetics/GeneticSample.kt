package com.firewave.rustmanager.genetics

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geneticSample")
data class GeneticSample(
    @Embedded val first:Gene,
    @Embedded val second:Gene,
    @Embedded val third:Gene,
    @Embedded val fourth:Gene,
    @Embedded val fifth:Gene,
    @Embedded val sixth:Gene,
    @ColumnInfo(name = "serverId") val serverId:Int = 0,
    @PrimaryKey(autoGenerate = true) val id:Int = 0
    ) {

    fun isSame(other:GeneticSample): Boolean {
        return other.first.name == this.first.name
                && other.second.name == this.second.name
                && this.third.name == other.third.name
                && this.fourth.name == other.fourth.name
                && this.fifth.name == other.fifth.name
                && this.sixth.name == other.sixth.name
    }
}