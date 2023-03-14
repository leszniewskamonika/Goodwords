package com.example.monika.goodwords.ui.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.UncategorizedWord

class CardUncategorizedRecyclerAdapter(private val listUncategorized: List<UncategorizedWord>) : RecyclerView.Adapter<CardUncategorizedRecyclerAdapter.UncategorizedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UncategorizedViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_uncategorized_recycler, parent, false)

        return UncategorizedViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: UncategorizedViewHolder, position: Int) {
        holder.textCardUncategorizedAng.text = listUncategorized[position].ang
        holder.textCardUncategorizedPol.text = listUncategorized[position].pol

    }


    override fun getItemCount(): Int {
        return listUncategorized.size
    }


    inner class UncategorizedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textCardUncategorizedAng: TextView
        var textCardUncategorizedPol: TextView


        init {
            textCardUncategorizedAng = view.findViewById<View>(R.id.textCardUncategorizedAng) as TextView
            textCardUncategorizedPol = view.findViewById<View>(R.id.textCardUncategorizedPol) as TextView

        }
    }
}