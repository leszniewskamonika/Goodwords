package com.example.monika.goodwords.ui.word

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.monika.goodwords.R


class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_add, container, false)

        val cardViewAddFamily: CardView = root.findViewById(R.id.cardViewAddFamily)
        val cardViewAddHome: CardView = root.findViewById(R.id.cardViewAddHome)
        val cardViewAddUncategorized: CardView = root.findViewById(R.id.cardViewAddUncategorized)

        cardViewAddFamily.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_word_add_family, null))
        cardViewAddHome.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_word_add_home, null))
        cardViewAddUncategorized.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_word_add_uncategorized, null))

        return root
    }

}