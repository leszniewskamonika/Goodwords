package com.example.monika.goodwords.ui.compare


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.monika.goodwords.R


class CompareFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val root = inflater.inflate(R.layout.fragment_compare, container, false)

        val cardViewComparePol_Ang: CardView = root.findViewById(R.id.cardViewComparePol_Ang)
        val cardViewCompareAng_Pol: CardView = root.findViewById(R.id.cardViewCompareAng_Pol)

        cardViewComparePol_Ang.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_compare_pol_ang, null))
        cardViewCompareAng_Pol.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_compare_ang_pol, null))


        return root
    }

}