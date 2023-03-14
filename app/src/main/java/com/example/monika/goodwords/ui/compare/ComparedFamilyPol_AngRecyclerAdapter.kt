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

class ComparedFamilyPol_AngRecyclerAdapter(private val listComparedFamily: List<FamilyWord>) : RecyclerView.Adapter<ComparedFamilyPol_AngRecyclerAdapter.FamilyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pol_ang_family_recycler, parent, false)

        return FamilyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.textComparedPol_AngFamilyPol.text = listComparedFamily[position].pol

        holder.textEditTextCompareFamilyAng = listComparedFamily[position].ang


    }

    override fun getItemCount(): Int {
        return listComparedFamily.size
    }



    inner class FamilyViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textComparedPol_AngFamilyPol: TextView
        var textInputEditTextFamilyAng: TextInputEditText
        var appCompatButtonPol_AngFamily: AppCompatButton

        var linearLayoutCompat: LinearLayoutCompat


        var textEditTextCompareFamilyAng = ""


        init {
            linearLayoutCompat =
                view.findViewById<View>(R.id.linearLayoutCompat) as LinearLayoutCompat

            textComparedPol_AngFamilyPol =
                view.findViewById<View>(R.id.textComparedPol_AngFamilyPol) as TextView
            textInputEditTextFamilyAng =
                view.findViewById<View>(R.id.textInputEditTextFamilyAng) as TextInputEditText

            appCompatButtonPol_AngFamily =
                view.findViewById<View>(R.id.appCompatButtonPol_AngFamily) as AppCompatButton

            appCompatButtonPol_AngFamily!!.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.appCompatButtonPol_AngFamily ->
                {
                    if(textEditTextCompareFamilyAng!! == textInputEditTextFamilyAng!!.text.toString().trim()){
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
