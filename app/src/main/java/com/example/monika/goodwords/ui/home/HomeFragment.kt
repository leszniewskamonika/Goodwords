package com.example.monika.goodwords.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.monika.goodwords.R

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val imageLogo: ImageView = root.findViewById(R.id.imageLogo)
        val cardViewWord: CardView = root.findViewById(R.id.cardViewWord)
        val cardViewCard: CardView = root.findViewById(R.id.cardViewCard)
        val cardViewCompare: CardView = root.findViewById(R.id.cardViewCompare)
        val cardViewGrammar: CardView = root.findViewById(R.id.cardViewGrammar)


        cardViewWord.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_word, null))
        cardViewCard.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_card, null))
        cardViewCompare.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_compare, null))
        cardViewGrammar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_gramma, null))

        return root
    }

}

