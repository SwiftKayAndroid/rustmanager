package com.firewave.rustmanager.genetics

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.firewave.rustmanager.R
import com.firewave.rustmanager.databinding.CrossbreedDiagramBinding

class CrossbreedDiagramFragment: DialogFragment() {

    companion object {
        fun newInstance(diagram:CrossbreedDiagram): CrossbreedDiagramFragment {
            val args = Bundle().also {
                it.putSerializable("diagram", diagram)
            }

            val fragment = CrossbreedDiagramFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        val view = LayoutInflater.from(requireContext())
            .inflate(R.layout.crossbreed_diagram, null, false)
        val binding = CrossbreedDiagramBinding.bind(view)
        val diagram = arguments?.getSerializable("diagram") as CrossbreedDiagram
        diagram.let {
            var position = 0

            diagram.breeders.forEach {
                var tvs: List<TextView> = when (position) {
                    0 -> listOf(
                        binding.oneOne, binding.oneTwo, binding.oneThree,
                        binding.oneFour, binding.oneFive, binding.oneSix
                    )
                    1 -> listOf(
                        binding.twoOne, binding.twoTwo, binding.twoThree, binding.twoFour,
                        binding.twoFive, binding.twoSix
                    )
                    2 -> listOf(
                        binding.threeOne, binding.threeTwo, binding.threeThree, binding.threeFour,
                        binding.threeFive, binding.threeSix
                    )
                    3 -> listOf(
                        binding.fourOne, binding.fourTwo, binding.fourThree, binding.fourFour,
                        binding.fourFive, binding.fourSix
                    )
                    4 -> listOf(
                        binding.sixOne, binding.sixTwo, binding.sixThree, binding.sixFour,
                        binding.sixFive, binding.sixSix
                    )
                    5 -> listOf(
                        binding.sevenOne, binding.sevenTwo, binding.sevenThree, binding.sevenFour,
                        binding.sevenFive, binding.sevenSix
                    )
                    6 -> listOf(
                        binding.eightOne, binding.eightTwo, binding.eightThree, binding.eightFour,
                        binding.eightFive, binding.eightSix
                    )
                    7 -> listOf(
                        binding.nineOne, binding.nineTwo, binding.nineThree, binding.nineFour,
                        binding.nineFive, binding.nineSix
                    )
                    else -> listOf()
                }
                position += 1
                applyGene(it, tvs)
            }
        }

        applyGene(diagram.result!!, listOf(binding.fiveOne, binding.fiveTwo, binding.fiveThree, binding.fiveFour,
        binding.fiveFive, binding.fiveSix))

        dialog.setContentView(view)
        return dialog
    }

    private fun applyGene(sample:GeneticSample, tvs:List<TextView>) {
        setGeneUI(tvs[0], sample.first)
        setGeneUI(tvs[1], sample.second)
        setGeneUI(tvs[2], sample.third)
        setGeneUI(tvs[3], sample.fourth)
        setGeneUI(tvs[4], sample.fifth)
        setGeneUI(tvs[5], sample.sixth)
    }

    private fun setGeneUI(tv:TextView, gene:Gene) {
        tv.text = gene.name
        tv.setTextColor(Color.BLACK)
        if (gene.name == "X" || gene.name == "W") {
            tv.setBackgroundColor(Color.RED)
        } else {
            tv.setBackgroundColor(Color.GREEN)
        }
    }
}