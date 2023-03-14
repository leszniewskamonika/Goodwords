package com.example.monika.goodwords.ui.compare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.UncategorizedWord
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class ComparedUncategorizedAng_PolRecyclerAdapter(private val listComparedUncategorized: List<UncategorizedWord>) : RecyclerView.Adapter<ComparedUncategorizedAng_PolRecyclerAdapter.UncategorizedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UncategorizedViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ang_pol_uncategorized_recycler, parent, false)

        return UncategorizedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UncategorizedViewHolder, position: Int) {
        holder.textComparedAng_PolUncategorizedAng.text = listComparedUncategorized[position].ang

        holder.textEditTextCompareUncategorizedPol = listComparedUncategorized[position].pol


    }

    override fun getItemCount(): Int {
        return listComparedUncategorized.size
    }


    inner class UncategorizedViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textComparedAng_PolUncategorizedAng: TextView
        var textInputEditTextUncategorizedPol: TextInputEditText
        var appCompatButtonAng_PolUncategorized: AppCompatButton

        var linearLayoutCompat: LinearLayoutCompat


        var textEditTextCompareUncategorizedPol = ""


        init {
            linearLayoutCompat =
                view.findViewById<View>(R.id.linearLayoutCompat) as LinearLayoutCompat

            textComparedAng_PolUncategorizedAng =
                view.findViewById<View>(R.id.textComparedAng_PolUncategorizedAng) as TextView
            textInputEditTextUncategorizedPol =
                view.findViewById<View>(R.id.textInputEditTextUncategorizedPol) as TextInputEditText

            appCompatButtonAng_PolUncategorized =
                view.findViewById<View>(R.id.appCompatButtonAng_PolUncategorized) as AppCompatButton

            appCompatButtonAng_PolUncategorized!!.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.appCompatButtonAng_PolUncategorized -> {
                    if (textEditTextCompareUncategorizedPol!! == textInputEditTextUncategorizedPol!!.text.toString().trim()) {
                        Snackbar.make(linearLayoutCompat!!, "Wpisane słowo jest prawidłowe", Snackbar.LENGTH_LONG).show()
                    }
                    else {
                        Snackbar.make(linearLayoutCompat!!, "Wpisane słowo nie jest prawidłowe", Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}