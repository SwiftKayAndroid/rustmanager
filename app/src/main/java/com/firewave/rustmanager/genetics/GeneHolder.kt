package com.firewave.rustmanager.genetics

object GeneHolder {

    var genes:ArrayList<GeneticSample> = ArrayList()

    public fun addGene(gene:GeneticSample) {
        genes.add(gene)
    }
}