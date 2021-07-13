package com.firewave.rustmanager.genetics

class GeneticSample(
    val first:Gene,
    val second:Gene,
    val third:Gene,
    val fourth:Gene,
    val fifth:Gene,
    val sixth:Gene
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