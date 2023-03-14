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

class ComparedHomePol_AngRecyclerAdapter(private val listComparedHome: List<HomeWord>) : RecyclerView.Adapter<ComparedHomePol_AngRecyclerAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pol_ang_home_recycler, parent, false)

        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.textComparedPol_AngHomePol.text = listComparedHome[position].pol

        holder.textEditTextCompareHomeAng = listComparedHome[position].ang


    }

    override fun getItemCount(): Int {
        return listComparedHome.size
    }



    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        var textComparedPol_AngHomePol: TextView
        var textInputEditTextHomeAng: TextInputEditText
        var appCompatButtonPol_AngHome: AppCompatButton

        var linearLayoutCompat: LinearLayoutCompat


        var textEditTextCompareHomeAng = ""


        init {
            linearLayoutCompat =
                view.findViewById<View>(R.id.linearLayoutCompat) as LinearLayoutCompat

            textComparedPol_AngHomePol =
                view.findViewById<View>(R.id.textComparedPol_AngHomePol) as TextView
            textInputEditTextHomeAng =
                view.findViewById<View>(R.id.textInputEditTextHomeAng) as TextInputEditText

            appCompatButtonPol_AngHome =
                view.findViewById<View>(R.id.appCompatButtonPol_AngHome) as AppCompatButton

            appCompatButtonPol_AngHome!!.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.appCompatButtonPol_AngHome ->
                {
                    if(textEditTextCompareHomeAng!! == textInputEditTextHomeAng!!.text.toString().trim()){
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