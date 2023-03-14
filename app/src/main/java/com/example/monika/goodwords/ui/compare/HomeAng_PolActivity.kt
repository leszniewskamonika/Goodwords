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
import com.example.monika.goodwords.model.HomeWord

class HomeAng_PolActivity: AppCompatActivity() {
    private val activity = this@HomeAng_PolActivity

    private lateinit var recyclerViewAng_PolHome: RecyclerView

    private lateinit var listComparedHome: MutableList<HomeWord>

    private lateinit var comparedHomeRecyclerAdapter: ComparedHomeAng_PolRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_ang_pol)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewAng_PolHome =findViewById<View>(R.id.recyclerViewAng_PolHome) as RecyclerView



    }

    private fun initObjects(){
        listComparedHome = ArrayList()
        comparedHomeRecyclerAdapter = ComparedHomeAng_PolRecyclerAdapter(listComparedHome)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewAng_PolHome.layoutManager = mLayoutManager
        recyclerViewAng_PolHome.itemAnimator = DefaultItemAnimator()
        recyclerViewAng_PolHome.setHasFixedSize(true)
        recyclerViewAng_PolHome.adapter = comparedHomeRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAng_PolHome.setLayoutManager(horizontalLayoutManager);

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<HomeWord>>() {

        override fun doInBackground(vararg p0: Void?): List<HomeWord> {
            return databaseHelper.getAllHomeWord()
        }

        override fun onPostExecute(result: List<HomeWord>?) {
            super.onPostExecute(result)
            listComparedHome.clear()
            listComparedHome.addAll(result!!)
        }

    }
}