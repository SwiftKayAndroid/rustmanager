package com.firewave.rustmanager.genetics

class GeneAdder {
    var x:Gene = Gene("X", 0.0f)
    var w:Gene = Gene("W", 0.0f)
    var y:Gene = Gene("Y", 0.0f)
    var h:Gene = Gene("H", 0.0f)
    var g:Gene = Gene("G", 0.0f)

    fun add(gene:Gene) {
        when (gene.name) {
            "X" -> x.add(gene)
            "W" -> w.add(gene)
            "Y" -> y.add(gene)
            "H" -> h.add(gene)
            "G" -> g.add(gene)
        }
    }

    fun getBest() : Gene {
        var red = x.compare(w)
        var green = y.compare(h)
        green = green.compare(g)
        return red.compare(green)
    }
}