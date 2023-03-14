package com.example.monika.goodwords.ui.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.FamilyWord

class CardFamilyRecyclerAdapter(private val listFamily: List<FamilyWord>) : RecyclerView.Adapter<CardFamilyRecyclerAdapter.FamilyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_family_recycler, parent, false)

        return FamilyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.textCardFamilyAng.text = listFamily[position].ang
        holder.textCardFamilyPol.text = listFamily[position].pol

    }


    override fun getItemCount(): Int {
        return listFamily.size
    }


    inner class FamilyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textCardFamilyAng: TextView
        var textCardFamilyPol: TextView


        init {
            textCardFamilyAng = view.findViewById<View>(R.id.textCardFamilyAng) as TextView
            textCardFamilyPol = view.findViewById<View>(R.id.textCardFamilyPol) as TextView

        }
    }
}