package com.firewave.rustmanager.genetics

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.firewave.rustmanager.R
import com.firewave.rustmanager.databinding.GeneticsSelectorBinding

class EnterGeneticsFragment:DialogFragment() {
    interface EnterGeneticsListener {
        fun onComplete()
    }

    companion object {
        fun newInstance() = EnterGeneticsFragment()
    }
    public var listener:EnterGeneticsListener? = null
    private var genes:ArrayList<Gene> = ArrayList()
    private lateinit var binding: GeneticsSelectorBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(context!!)
        val root = LayoutInflater.from(context).inflate(R.layout.genetics_selector, null, false)
        binding = GeneticsSelectorBinding.bind(root)

        binding.close.setOnClickListener {
            listener?.onComplete()
            dismiss()
        }

        binding.x.setOnClickListener { addGene(Gene("X", 0.9f)) }
        binding.w.setOnClickListener { addGene(Gene("W", 0.9f)) }
        binding.h.setOnClickListener { addGene(Gene("H", 0.5f)) }
        binding.y.setOnClickListener { addGene(Gene("Y", 0.5f)) }
        binding.g.setOnClickListener { addGene(Gene("G", 0.5f)) }
        binding.saveGene.setOnClickListener {
            if (genes.size >= 6) {
                GeneHolder.addGene(
                    GeneticSample(
                        genes[0], genes[1], genes[2],
                        genes[3], genes[4], genes[5]
                    )
                )
                clear()
            }
        }
        binding.clear.setOnClickListener { clear() }

        dialog.setContentView(root)
        return dialog
    }

    private fun addGene(gene:Gene) {
        val pos = genes.size
        when (pos) {
            0 -> setGeneUI(binding.first, gene)
            1 -> setGeneUI(binding.second, gene)
            2 -> setGeneUI(binding.third, gene)
            3 -> setGeneUI(binding.fourth, gene)
            4 -> setGeneUI(binding.fifth, gene)
            5 -> setGeneUI(binding.sixth, gene)
        }
        genes.add(gene)
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

    private fun clear() {
        binding.first.text = ""
        binding.first.setBackgroundColor(Color.BLACK)
        binding.second.text = ""
        binding.second.setBackgroundColor(Color.BLACK)
        binding.third.text = ""
        binding.third.setBackgroundColor(Color.BLACK)
        binding.fourth.text = ""
        binding.fourth.setBackgroundColor(Color.BLACK)
        binding.fifth.text = ""
        binding.fifth.setBackgroundColor(Color.BLACK)
        binding.sixth.text = ""
        binding.sixth.setBackgroundColor(Color.BLACK)
        genes.clear()
    }
}