package com.example.monika.goodwords.ui.compare


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.monika.goodwords.R
import com.example.monika.goodwords.ui.card.FamilyCardActivity
import com.example.monika.goodwords.ui.card.HomeCardActivity
import com.example.monika.goodwords.ui.card.UncategorizedCardActivity


class Ang_PolFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_ang__pol, container, false)

        val cardViewCompareAng_PolFamily: CardView = root.findViewById(R.id.cardViewCompareAng_PolFamily)
        val cardViewCompareAng_PolHome: CardView = root.findViewById(R.id.cardViewCompareAng_PolHome)
        val cardViewCompareAng_PolUncategorized: CardView = root.findViewById(R.id.cardViewCompareAng_PolUncategorized)


        cardViewCompareAng_PolFamily.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, FamilyAng_PolActivity::class.java)
            startActivity(intent)
        })

        cardViewCompareAng_PolHome.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, HomeAng_PolActivity::class.java)
            startActivity(intent)
        })

        cardViewCompareAng_PolUncategorized.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, UncategorizedAng_PolActivity::class.java)
            startActivity(intent)
        })


        return root
    }

}