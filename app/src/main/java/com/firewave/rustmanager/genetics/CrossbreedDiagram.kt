package com.firewave.rustmanager.genetics

import java.io.Serializable

class CrossbreedDiagram: Serializable {
    public var breeders:ArrayList<GeneticSample> = ArrayList()
    var result:GeneticSample? = null
}