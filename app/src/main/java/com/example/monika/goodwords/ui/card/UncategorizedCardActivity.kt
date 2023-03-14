package com.example.monika.goodwords.ui.card

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.bazadanych.DatabaseHelper
import com.example.monika.goodwords.model.UncategorizedWord

class UncategorizedCardActivity: AppCompatActivity() {

    private val activity = this@UncategorizedCardActivity
    private lateinit var recyclerViewCardUncategorized: RecyclerView
    private lateinit var listUncategorized: MutableList<UncategorizedWord>

    private lateinit var cardUncategorizedRecyclerAdapter: CardUncategorizedRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uncategorized_card)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewCardUncategorized =findViewById<View>(R.id.recyclerViewCardUncategorized) as RecyclerView
        linearLayout = findViewById<View>(R.id.linearLayout) as LinearLayout

    }

    private fun initObjects(){
        listUncategorized = ArrayList()
        cardUncategorizedRecyclerAdapter = CardUncategorizedRecyclerAdapter(listUncategorized)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCardUncategorized.layoutManager = mLayoutManager
        recyclerViewCardUncategorized.setHasFixedSize(true)
        recyclerViewCardUncategorized.adapter = cardUncategorizedRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<UncategorizedWord>>() {

        override fun doInBackground(vararg p0: Void?): List<UncategorizedWord> {
            return databaseHelper.getAllUncategorizedWord()
        }

        override fun onPostExecute(result: List<UncategorizedWord>?) {
            super.onPostExecute(result)
            listUncategorized.clear()
            listUncategorized.addAll(result!!)
        }

    }
}