package com.firewave.rustmanager.genetics

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firewave.rustmanager.R
import com.firewave.rustmanager.databinding.ItemGeneticSampleBinding

class PotentialCrossbreedsAdapter(val listener:CrossbreedAdapterListener)
    :RecyclerView.Adapter<PotentialCrossbreedsAdapter.PotentialCrossbreedsViewHolder>() {

    interface CrossbreedAdapterListener {
        fun onItemClicked(diagram: CrossbreedDiagram)
    }

    var items:ArrayList<CrossbreedDiagram> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotentialCrossbreedsViewHolder {
        return PotentialCrossbreedsViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genetic_sample, null, false))
    }

    override fun onBindViewHolder(holder: PotentialCrossbreedsViewHolder, position: Int) {
        val sample = items[position].result!!
        setGeneUI(holder.binding.first, sample.first)
        setGeneUI(holder.binding.second, sample.second)
        setGeneUI(holder.binding.third, sample.third)
        setGeneUI(holder.binding.fourth, sample.fourth)
        setGeneUI(holder.binding.fifth, sample.fifth)
        setGeneUI(holder.binding.sixth, sample.sixth)

        holder.itemView.setOnClickListener {
            listener.onItemClicked(items[position])
        }
    }

    private fun setGeneUI(tv: TextView, gene:Gene) {
        tv.text = gene.name
        tv.setTextColor(Color.BLACK)
        if (gene.name == "X" || gene.name == "W") {
            tv.setBackgroundColor(Color.RED)
        } else {
            tv.setBackgroundColor(Color.GREEN)
        }
    }

    override fun getItemCount() = items.size

    public class PotentialCrossbreedsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding:ItemGeneticSampleBinding = ItemGeneticSampleBinding.bind(itemView)
    }
}