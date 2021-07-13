package com.firewave.rustmanager.genetics

open class Gene(val name:String, var weight:Float) {
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