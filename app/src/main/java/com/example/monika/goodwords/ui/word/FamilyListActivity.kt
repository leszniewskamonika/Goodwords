package com.example.monika.goodwords.ui.word

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.bazadanych.DatabaseHelper
import com.example.monika.goodwords.model.FamilyWord


class FamilyListActivity: AppCompatActivity() {
    private val activity = this@FamilyListActivity

    private lateinit var recyclerViewFamily: RecyclerView
    private lateinit var listFamily: MutableList<FamilyWord>

    private lateinit var familyRecyclerAdapter: FamilyRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_list)
        supportActionBar!!.hide()
        initViews()
        initObjects()
    }

    private fun initViews() {
        recyclerViewFamily = findViewById<View>(R.id.recyclerViewFamily) as RecyclerView


    }

    private fun initObjects() {
        listFamily = ArrayList()
        familyRecyclerAdapter = FamilyRecyclerAdapter(listFamily)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewFamily.layoutManager = mLayoutManager
        recyclerViewFamily.setHasFixedSize(true)
        recyclerViewFamily.adapter = familyRecyclerAdapter
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