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
import com.example.monika.goodwords.model.FamilyWord


class FamilyCardActivity: AppCompatActivity() {
    private val activity = this@FamilyCardActivity

    private lateinit var recyclerViewCardFamily: RecyclerView
    private lateinit var listFamily: MutableList<FamilyWord>

    private lateinit var cardFamilyRecyclerAdapter: CardFamilyRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_card)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewCardFamily =findViewById<View>(R.id.recyclerViewCardFamily) as RecyclerView
        linearLayout = findViewById<View>(R.id.linearLayout) as LinearLayout

    }

    private fun initObjects(){
        listFamily = ArrayList()
        cardFamilyRecyclerAdapter = CardFamilyRecyclerAdapter(listFamily)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCardFamily.layoutManager = mLayoutManager
        recyclerViewCardFamily.setHasFixedSize(true)
        recyclerViewCardFamily.adapter = cardFamilyRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<FamilyWord>>() {

        override fun doInBackground(vararg p0: Void?): List<FamilyWord> {
            return databaseHelper.getAllFamilyWord()
        }

        override fun onPostExecute(result: List<FamilyWord>?) {
            super.onPostExecute(result)
            listFamily.clear()
            listFamily.addAll(result!!)
        }

    }
}