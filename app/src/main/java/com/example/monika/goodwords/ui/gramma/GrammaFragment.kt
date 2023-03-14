package com.example.monika.goodwords.ui.gramma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.monika.goodwords.R



class GrammaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_gramma, container, false)

        val cardViewPresentSimple: CardView = root.findViewById(R.id.cardViewPresentSimple)
        val cardViewPresentContinous: CardView = root.findViewById(R.id.cardViewPresentContinous)
        val cardViewPresentPerfect: CardView = root.findViewById(R.id.cardViewPresentPerfect)

        cardViewPresentSimple.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_gramma_present_simple, null))
        cardViewPresentContinous.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_gramma_present_continuous, null))
        cardViewPresentPerfect.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_gramma_present_perfect, null))

        return root
    }
}