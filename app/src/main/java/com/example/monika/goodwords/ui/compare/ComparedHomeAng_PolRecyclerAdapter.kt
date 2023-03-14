package com.example.monika.goodwords.ui.compare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.HomeWord
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class ComparedHomeAng_PolRecyclerAdapter(private val listComparedHome: List<HomeWord>) : RecyclerView.Adapter<ComparedHomeAng_PolRecyclerAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ang_pol_home_recycler, parent, false)

        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.textComparedAng_PolHomeAng.text = listComparedHome[position].ang

        holder.textEditTextCompareHomePol = listComparedHome[position].pol


    }

    override fun getItemCount(): Int {
        return listComparedHome.size
    }



    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textComparedAng_PolHomeAng: TextView
        var textInputEditTextHomePol: TextInputEditText
        var appCompatButtonAng_PolHome: AppCompatButton

        var linearLayoutCompat: LinearLayoutCompat


        var textEditTextCompareHomePol = ""


        init {
            linearLayoutCompat =
                view.findViewById<View>(R.id.linearLayoutCompat) as LinearLayoutCompat

            textComparedAng_PolHomeAng =
                view.findViewById<View>(R.id.textComparedAng_PolHomeAng) as TextView
            textInputEditTextHomePol =
                view.findViewById<View>(R.id.textInputEditTextHomePol) as TextInputEditText

            appCompatButtonAng_PolHome =
                view.findViewById<View>(R.id.appCompatButtonAng_PolHome) as AppCompatButton

            appCompatButtonAng_PolHome!!.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.appCompatButtonAng_PolHome ->
                {
                    if(textEditTextCompareHomePol!! == textInputEditTextHomePol!!.text.toString().trim()){
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