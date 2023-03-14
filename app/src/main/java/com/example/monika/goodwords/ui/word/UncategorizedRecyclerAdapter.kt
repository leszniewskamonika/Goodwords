package com.example.monika.goodwords.ui.word

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.UncategorizedWord

class UncategorizedRecyclerAdapter(private val listUncategorized: List<UncategorizedWord>) : RecyclerView.Adapter<UncategorizedRecyclerAdapter.UncategorizedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UncategorizedViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_uncategorized_recycler, parent, false)

        return UncategorizedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UncategorizedViewHolder, position: Int) {
        holder.textViewUncategorizedAng.text = listUncategorized[position].ang
        holder.textViewUncategorizedPol.text = listUncategorized[position].pol

    }

    override fun getItemCount(): Int {
        return listUncategorized.size
    }



    inner class UncategorizedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewUncategorizedAng: AppCompatTextView
        var textViewUncategorizedPol: AppCompatTextView


        init {
            textViewUncategorizedAng = view.findViewById<View>(R.id.textViewUncategorizedAng) as AppCompatTextView
            textViewUncategorizedPol = view.findViewById<View>(R.id.textViewUncategorizedPol) as AppCompatTextView

        }
    }
}