package com.firewave.rustmanager.genetics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.firewave.rustmanager.R
import com.firewave.rustmanager.databinding.FragmentGeneticsBinding

class GeneticsFragment
    : Fragment(), EnterGeneticsFragment.EnterGeneticsListener, PotentialCrossbreedsAdapter.CrossbreedAdapterListener {

    companion object {
        fun newInstance() = GeneticsFragment()
    }

    lateinit var binding: FragmentGeneticsBinding
    val currentGeneticsAdapter by lazy { GeneticSampleAdapter() }
    val potentialCrossbreedsAdapter by lazy { PotentialCrossbreedsAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_genetics, null, false)
        binding = FragmentGeneticsBinding.bind(root)

        binding.addGeneSample.setOnClickListener {
            val frag = EnterGeneticsFragment.newInstance()
            frag.listener = this
            frag.show(childFragmentManager, "EnterGeneticsFragment")
        }

        binding.calculate.setOnClickListener { calculate() }

        binding.recyclerView.adapter = currentGeneticsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        binding.potentialCrossbreedsRv.adapter = potentialCrossbreedsAdapter
        binding.potentialCrossbreedsRv.layoutManager = LinearLayoutManager(context)

        return root
    }

    private fun calculate() {
        var diagrams = CrossbreedCalculations.getCrossbreadResults(GeneHolder.genes)
        potentialCrossbreedsAdapter.items = diagrams
        potentialCrossbreedsAdapter.notifyDataSetChanged()
    }

    override fun onComplete() {
        updateDisplay()
    }

    private fun updateDisplay() {
        currentGeneticsAdapter.items = GeneHolder.genes
        currentGeneticsAdapter.notifyDataSetChanged()
    }

    override fun onItemClicked(diagram: CrossbreedDiagram) {
        val frag = CrossbreedDiagramFragment.newInstance(diagram)
        frag.show(childFragmentManager, "Diagram")
    }
}