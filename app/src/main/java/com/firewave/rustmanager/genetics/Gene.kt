package com.firewave.rustmanager.genetics

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gene")
open class Gene(
    @ColumnInfo(name = "geneName") val name:String,
    @ColumnInfo(name = "weight") var weight:Float,
    @PrimaryKey(autoGenerate = true) val id:Int = 0
    ) {
    public fun compare(other:Gene) : Gene {
        if (other.weight > this.weight) {
            return other
        } else if (other.weight == this.weight && other.name == this.name) {
            return this
        } else if (other.weight == this.weight) {
            return SplitGene(this, other)
        } else {
            return this
        }
    }

    fun add(other:Gene) {
        if (other.name == this.name) {
            this.weight += other.weight
        }
    }
}