package com.firewave.rustmanager.genetics

import com.firewave.rustmanager.server.Server

object CrossbreedCalculations {
    public fun getCrossbreadResults(samples:ArrayList<GeneticSample>) : ArrayList<CrossbreedDiagram> {
        val diagrams = ArrayList<CrossbreedDiagram>()
        samples.forEach {

            samples.forEach { sub ->
                val breeders = arrayListOf(it, sub)
                val sample = crossBreed(breeders)
                val diagram = CrossbreedDiagram()
                diagram.breeders = breeders
                diagram.result = sample
                addDiagram(diagram, diagrams)

                samples.forEach { subTwo ->
                    val breedersTwo = arrayListOf(it, sub, subTwo)
                    val sampleTwo = crossBreed(breedersTwo)
                    val diagramTwo = CrossbreedDiagram()
                    diagramTwo.breeders = breedersTwo
                    diagramTwo.result = sampleTwo
                    addDiagram(diagramTwo, diagrams)

                    samples.forEach { subThree ->
                        val breedersThree = arrayListOf(it, sub, subTwo, subThree)
                        val sampleThree = crossBreed(breedersThree)
                        val diagramThree = CrossbreedDiagram()
                        diagramThree.breeders = breedersThree
                        diagramThree.result = sampleThree
                        addDiagram(diagramThree, diagrams)

                        samples.forEach { subFour ->
                            val breedersFour = arrayListOf(it, sub, subTwo, subThree, subFour)
                            val sampleFour = crossBreed(breedersFour)
                            val diagramFour = CrossbreedDiagram()
                            diagramFour.breeders = breedersFour
                            diagramFour.result = sampleFour
                            addDiagram(diagramFour, diagrams)

                            samples.forEach { subFive ->
                                val breedersFive = arrayListOf(it, sub, subTwo, subThree, subFour, subFive)
                                val sampleFive = crossBreed(breedersFive)
                                val diagramFive = CrossbreedDiagram()
                                diagramFive.breeders = breedersFive
                                diagramFive.result = sampleFive
                                addDiagram(diagramFive, diagrams)

                                samples.forEach { subSix ->
                                    val breedersSix = arrayListOf(it, sub, subTwo, subThree, subFour, subFive, subSix)
                                    val sampleSix = crossBreed(breedersSix)
                                    val diagramSix = CrossbreedDiagram()
                                    diagramSix.breeders = breedersSix
                                    diagramSix.result = sampleSix
                                    addDiagram(diagramSix, diagrams)

                                    samples.forEach { subSeven ->
                                        val breedersSeven = arrayListOf(it, sub, subTwo,
                                            subThree, subFour, subFive, subSix, subSeven)
                                        val sampleSeven = crossBreed(breedersSeven)
                                        val diagramSeven = CrossbreedDiagram()
                                        diagramSeven.breeders = breedersSeven
                                        diagramSeven.result = sampleSeven
                                        addDiagram(diagramSeven, diagrams)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return diagrams
    }

    private fun addDiagram(diagram: CrossbreedDiagram, diagrams:ArrayList<CrossbreedDiagram>) {
        var hasSame = false

        diagrams.forEach {
            hasSame = hasSame || it.result!!.isSame(diagram.result!!)
        }
        if (!hasSame) {
            diagrams.add(diagram)
        }
    }

    private fun crossBreed(samples:ArrayList<GeneticSample>) : GeneticSample {
        val first = GeneAdder()
        val second = GeneAdder()
        val third = GeneAdder()
        val fourth = GeneAdder()
        val fifth = GeneAdder()
        val sixth = GeneAdder()
        samples.forEach {
            first.add(it.first)
            second.add(it.second)
            third.add(it.third)
            fourth.add(it.fourth)
            fifth.add(it.fifth)
            sixth.add(it.sixth)
        }
        return GeneticSample(first.getBest(), second.getBest(), third.getBest(), fourth.getBest(), fifth.getBest(), sixth.getBest())
    }
}