package com.example.monika.goodwords.ui.word

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.FamilyWord

class FamilyRecyclerAdapter(private val listFamily: List<FamilyWord>) : RecyclerView.Adapter<FamilyRecyclerAdapter.FamilyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_family_recycler, parent, false)

        return FamilyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.textViewFamilyAng.text = listFamily[position].ang
        holder.textViewFamilyPol.text = listFamily[position].pol

    }



    override fun getItemCount(): Int {
        return listFamily.size
    }



    inner class FamilyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewFamilyAng: AppCompatTextView
        var textViewFamilyPol: AppCompatTextView


        init {
            textViewFamilyAng = view.findViewById<View>(R.id.textViewFamilyAng) as AppCompatTextView
            textViewFamilyPol = view.findViewById<View>(R.id.textViewFamilyPol) as AppCompatTextView

        }
    }
}