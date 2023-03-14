package com.example.monika.goodwords.ui.word

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.monika.goodwords.R

class WordFragment : Fragment() {



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_word, container, false)

        val cardViewSearch: CardView = root.findViewById(R.id.cardViewSearch)
        val cardViewAdd: CardView = root.findViewById(R.id.cardViewAdd)

        cardViewSearch.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_word_search, null))
        cardViewAdd.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.nav_word_add, null))

        return root
    }
}