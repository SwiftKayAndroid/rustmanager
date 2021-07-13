package com.firewave.rustmanager.genetics

class SplitGene(val firstGene:Gene, val secondGene:Gene) : Gene((firstGene.name + secondGene.name), firstGene.weight) {
}