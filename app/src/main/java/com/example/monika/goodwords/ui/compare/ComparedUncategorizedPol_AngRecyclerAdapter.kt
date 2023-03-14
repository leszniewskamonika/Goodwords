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

class ComparedUncategorizedPol_AngRecyclerAdapter(private val listComparedUncategorized: List<UncategorizedWord>) : RecyclerView.Adapter<ComparedUncategorizedPol_AngRecyclerAdapter.UncategorizedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UncategorizedViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pol_ang_uncategorized_recycler, parent, false)

        return UncategorizedViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UncategorizedViewHolder, position: Int) {
        holder.textComparedPol_AngUncategorizedPol.text = listComparedUncategorized[position].pol

        holder.textEditTextCompareUncategorizedAng = listComparedUncategorized[position].ang


    }

    override fun getItemCount(): Int {
        return listComparedUncategorized.size
    }



    inner class UncategorizedViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textComparedPol_AngUncategorizedPol: TextView
        var textInputEditTextUncategorizedAng: TextInputEditText
        var appCompatButtonPol_AngUncategorized: AppCompatButton

        var linearLayoutCompat: LinearLayoutCompat


        var textEditTextCompareUncategorizedAng = ""


        init {
            linearLayoutCompat =
                view.findViewById<View>(R.id.linearLayoutCompat) as LinearLayoutCompat

            textComparedPol_AngUncategorizedPol =
                view.findViewById<View>(R.id.textComparedPol_AngUncategorizedPol) as TextView
            textInputEditTextUncategorizedAng =
                view.findViewById<View>(R.id.textInputEditTextUncategorizedAng) as TextInputEditText

            appCompatButtonPol_AngUncategorized =
                view.findViewById<View>(R.id.appCompatButtonPol_AngUncategorized) as AppCompatButton

            appCompatButtonPol_AngUncategorized!!.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.appCompatButtonPol_AngUncategorized ->
                {
                    if(textEditTextCompareUncategorizedAng!! == textInputEditTextUncategorizedAng!!.text.toString().trim()){
                        Snackbar.make(linearLayoutCompat!!, "Wpisane słowo jest prawidłowe", Snackbar.LENGTH_LONG).show()
                    }

                    else{
                        Snackbar.make(linearLayoutCompat!!, "Wpisane słowo nie jest prawidłowe", Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

}