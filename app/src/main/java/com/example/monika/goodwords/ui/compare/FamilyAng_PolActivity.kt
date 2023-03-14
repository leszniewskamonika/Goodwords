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
import com.example.monika.goodwords.model.FamilyWord

class FamilyAng_PolActivity: AppCompatActivity() {

    private val activity = this@FamilyAng_PolActivity

    private lateinit var recyclerViewAng_PolFamily: RecyclerView

    private lateinit var listComparedFamily: MutableList<FamilyWord>

    private lateinit var comparedFamilyRecyclerAdapter: ComparedFamilyAng_PolRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_ang_pol)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewAng_PolFamily =findViewById<View>(R.id.recyclerViewAng_PolFamily) as RecyclerView



    }

    private fun initObjects(){
        listComparedFamily = ArrayList()
        comparedFamilyRecyclerAdapter = ComparedFamilyAng_PolRecyclerAdapter(listComparedFamily)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewAng_PolFamily.layoutManager = mLayoutManager
        recyclerViewAng_PolFamily.itemAnimator = DefaultItemAnimator()
        recyclerViewAng_PolFamily.setHasFixedSize(true)
        recyclerViewAng_PolFamily.adapter = comparedFamilyRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAng_PolFamily.setLayoutManager(horizontalLayoutManager);

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<FamilyWord>>() {

        override fun doInBackground(vararg p0: Void?): List<FamilyWord> {
            return databaseHelper.getAllFamilyWord()
        }

        override fun onPostExecute(result: List<FamilyWord>?) {
            super.onPostExecute(result)
            listComparedFamily.clear()
            listComparedFamily.addAll(result!!)
        }

    }
}