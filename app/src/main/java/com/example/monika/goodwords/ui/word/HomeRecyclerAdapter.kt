package com.example.monika.goodwords.ui.word

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.model.HomeWord

class HomeRecyclerAdapter(private val listHome: List<HomeWord>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_recycler, parent, false)

        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.textViewHomeAng.text = listHome[position].ang
        holder.textViewHomePol.text = listHome[position].pol

    }

    override fun getItemCount(): Int {
        return listHome.size
    }



    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var textViewHomeAng: AppCompatTextView
        var textViewHomePol: AppCompatTextView


        init {
            textViewHomeAng = view.findViewById<View>(R.id.textViewHomeAng) as AppCompatTextView
            textViewHomePol = view.findViewById<View>(R.id.textViewHomePol) as AppCompatTextView

        }
    }
}