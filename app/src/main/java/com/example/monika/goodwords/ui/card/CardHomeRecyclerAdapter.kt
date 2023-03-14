package com.example.monika.goodwords.ui.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.HomeWord

class CardHomeRecyclerAdapter(private val listHome: List<HomeWord>) : RecyclerView.Adapter<CardHomeRecyclerAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_home_recycler, parent, false)

        return HomeViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.textCardHomeAng.text = listHome[position].ang
        holder.textCardHomePol.text = listHome[position].pol

    }


    override fun getItemCount(): Int {
        return listHome.size
    }


    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textCardHomeAng: TextView
        var textCardHomePol: TextView


        init {
            textCardHomeAng = view.findViewById<View>(R.id.textCardHomeAng) as TextView
            textCardHomePol = view.findViewById<View>(R.id.textCardHomePol) as TextView

        }
    }
}