package com.example.monika.goodwords.ui.card


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.monika.goodwords.R

class CardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_card, container, false)

        val cardViewCardFamily: CardView = root.findViewById(R.id.cardViewCardFamily)
        val cardViewCardHome: CardView = root.findViewById(R.id.cardViewCardHome)
        val cardViewCardUncategorized: CardView = root.findViewById(R.id.cardViewCardUncategorized)


        cardViewCardFamily.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, FamilyCardActivity::class.java)
            startActivity(intent)
        })

        cardViewCardHome.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HomeCardActivity::class.java)
            startActivity(intent)
        })

        cardViewCardUncategorized.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, UncategorizedCardActivity::class.java)
            startActivity(intent)
        })


        return root
    }

}