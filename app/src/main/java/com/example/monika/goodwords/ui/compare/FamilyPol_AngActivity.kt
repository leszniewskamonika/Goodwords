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

class FamilyPol_AngActivity: AppCompatActivity() {

    private val activity = this@FamilyPol_AngActivity

    private lateinit var recyclerViewPol_AngFamily: RecyclerView

    private lateinit var listComparedFamily: MutableList<FamilyWord>

    private lateinit var comparedFamilyRecyclerAdapter: ComparedFamilyPol_AngRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family_pol_ang)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewPol_AngFamily =findViewById<View>(R.id.recyclerViewPol_AngFamily) as RecyclerView



    }

    private fun initObjects(){
        listComparedFamily = ArrayList()
        comparedFamilyRecyclerAdapter = ComparedFamilyPol_AngRecyclerAdapter(listComparedFamily)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewPol_AngFamily.layoutManager = mLayoutManager
        recyclerViewPol_AngFamily.itemAnimator = DefaultItemAnimator()
        recyclerViewPol_AngFamily.setHasFixedSize(true)
        recyclerViewPol_AngFamily.adapter = comparedFamilyRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPol_AngFamily.setLayoutManager(horizontalLayoutManager);

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