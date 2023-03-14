package com.example.monika.goodwords.ui.word


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.monika.goodwords.R


class SearchFragment : Fragment() {

   override fun onCreateView(
       inflater: LayoutInflater,
       container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View? {

        val root = inflater.inflate(R.layout.fragment_search, container, false)

        val cardViewSearchFamily: CardView = root.findViewById(R.id.cardViewSearchFamily)
        val cardViewSearchHome: CardView = root.findViewById(R.id.cardViewSearchHome)
        val cardViewSearchUncategorized: CardView = root.findViewById(R.id.cardViewSearchUncategorized)


       cardViewSearchFamily.setOnClickListener(View.OnClickListener {
           val intent = Intent(activity, FamilyListActivity::class.java)
          startActivity(intent)
       })

       cardViewSearchHome.setOnClickListener(View.OnClickListener {
           val intent = Intent(activity, HomeListActivity::class.java)
           startActivity(intent)
       })

       cardViewSearchUncategorized.setOnClickListener(View.OnClickListener {
           val intent = Intent(activity, UncategorizedListActivity::class.java)
           startActivity(intent)
       })


        return root
    }

}