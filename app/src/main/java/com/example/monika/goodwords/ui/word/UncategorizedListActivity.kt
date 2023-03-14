package com.example.monika.goodwords.ui.word

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

class UncategorizedListActivity: AppCompatActivity() {
    private val activity = this@UncategorizedListActivity

    private lateinit var recyclerViewUncategorized: RecyclerView
    private lateinit var listUncategorized: MutableList<UncategorizedWord>

    private lateinit var uncategorizedRecyclerAdapter: UncategorizedRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uncategorized_list)
        supportActionBar!!.hide()
        initViews()
        initObjects()
    }

    private fun initViews(){
        recyclerViewUncategorized =findViewById<View>(R.id.recyclerViewUncategorized) as RecyclerView

    }

    private fun initObjects(){
        listUncategorized = ArrayList()
        uncategorizedRecyclerAdapter = UncategorizedRecyclerAdapter(listUncategorized)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewUncategorized.layoutManager = mLayoutManager
        recyclerViewUncategorized.itemAnimator = DefaultItemAnimator()
        recyclerViewUncategorized.setHasFixedSize(true)
        recyclerViewUncategorized.adapter = uncategorizedRecyclerAdapter
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