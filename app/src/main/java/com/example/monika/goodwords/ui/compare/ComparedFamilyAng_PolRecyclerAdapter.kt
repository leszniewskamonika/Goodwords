package com.example.monika.goodwords.ui.compare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.FamilyWord
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class ComparedFamilyAng_PolRecyclerAdapter(private val listComparedFamily: List<FamilyWord>) : RecyclerView.Adapter<ComparedFamilyAng_PolRecyclerAdapter.FamilyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ang_pol_family_recycler, parent, false)

        return FamilyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.textComparedAng_PolFamilyAng.text = listComparedFamily[position].ang

        holder.textEditTextCompareFamilyPol = listComparedFamily[position].pol


    }

    override fun getItemCount(): Int {
        return listComparedFamily.size
    }



    inner class FamilyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textComparedAng_PolFamilyAng: TextView
        var textInputEditTextFamilyPol: TextInputEditText
        var appCompatButtonAng_PolFamily: AppCompatButton

        var linearLayoutCompat: LinearLayoutCompat


        var textEditTextCompareFamilyPol = ""


        init {
            linearLayoutCompat =
                view.findViewById<View>(R.id.linearLayoutCompat) as LinearLayoutCompat

            textComparedAng_PolFamilyAng =
                view.findViewById<View>(R.id.textComparedAng_PolFamilyAng) as TextView
            textInputEditTextFamilyPol =
                view.findViewById<View>(R.id.textInputEditTextFamilyPol) as TextInputEditText

            appCompatButtonAng_PolFamily =
                view.findViewById<View>(R.id.appCompatButtonAng_PolFamily) as AppCompatButton

            appCompatButtonAng_PolFamily!!.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.appCompatButtonAng_PolFamily ->
                {
                    if(textEditTextCompareFamilyPol!! == textInputEditTextFamilyPol!!.text.toString().trim()){
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
