package com.example.monika.goodwords.ui.compare

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.bazadanych.DatabaseHelper
import com.example.monika.goodwords.model.UncategorizedWord

class UncategorizedPol_AngActivity: AppCompatActivity() {
    private val activity = this@UncategorizedPol_AngActivity

    private lateinit var recyclerViewPol_AngUncategorized: RecyclerView

    private lateinit var listComparedUncategorized: MutableList<UncategorizedWord>

    private lateinit var comparedUncategorizedRecyclerAdapter: ComparedUncategorizedPol_AngRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uncategorized_pol_ang)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewPol_AngUncategorized =findViewById<View>(R.id.recyclerViewPol_AngUncategorized) as RecyclerView



    }

    private fun initObjects(){
        listComparedUncategorized = ArrayList()
        comparedUncategorizedRecyclerAdapter = ComparedUncategorizedPol_AngRecyclerAdapter(listComparedUncategorized)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewPol_AngUncategorized.layoutManager = mLayoutManager
        recyclerViewPol_AngUncategorized.itemAnimator = DefaultItemAnimator()
        recyclerViewPol_AngUncategorized.setHasFixedSize(true)
        recyclerViewPol_AngUncategorized.adapter = comparedUncategorizedRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPol_AngUncategorized.setLayoutManager(horizontalLayoutManager);

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<UncategorizedWord>>() {

        override fun doInBackground(vararg p0: Void?): List<UncategorizedWord> {
            return databaseHelper.getAllUncategorizedWord()
        }

        override fun onPostExecute(result: List<UncategorizedWord>?) {
            super.onPostExecute(result)
            listComparedUncategorized.clear()
            listComparedUncategorized.addAll(result!!)
        }

    }
}