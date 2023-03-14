package com.example.monika.goodwords.ui.compare

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.ui.card.FamilyCardActivity
import com.example.monika.goodwords.ui.card.HomeCardActivity
import com.example.monika.goodwords.ui.card.UncategorizedCardActivity

class Pol_AngFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_pol__ang, container, false)

        val cardViewComparePol_AngFamily: CardView = root.findViewById(R.id.cardViewComparePol_AngFamily)
        val cardViewComparePol_AngHome: CardView = root.findViewById(R.id.cardViewComparePol_AngHome)
        val cardViewComparePol_AngUncategorized: CardView = root.findViewById(R.id.cardViewComparePol_AngUncategorized)


        cardViewComparePol_AngFamily.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, FamilyPol_AngActivity::class.java)
            startActivity(intent)
        })

        cardViewComparePol_AngHome.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HomePol_AngActivity::class.java)
            startActivity(intent)
        })

        cardViewComparePol_AngUncategorized.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, UncategorizedPol_AngActivity::class.java)
            startActivity(intent)
        })


        return root
    }
}